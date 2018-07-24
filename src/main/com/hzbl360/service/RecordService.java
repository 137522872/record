package com.hzbl360.service;


import com.hzbl360.mapper.GoodsMapper;
import com.hzbl360.mapper.RecordMapper;
import com.hzbl360.pojo.Goods;
import com.hzbl360.pojo.Record;
import com.hzbl360.tools.JsonDateValueProcessor;
import com.hzbl360.tools.Page;
import com.hzbl360.tools.ReturnResult;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private GoodsMapper goodsMapper;


    //通过物品id查询领用记录
    public List<Record> getRecordByGoodsId(Integer goodsId){

        List<Record> recordById = recordMapper.getRecordByGoodsId(goodsId);

        return recordById;
    }

    //列出所有领用记录

    /**
     *
     * 领用记录列表页
     * @param page
     * @return
     */
    public String getRecordAll(Page page){

        int count = recordMapper.getRecordCount();

        Page<Record> pager = new Page<>();


        if(page.getCurrentPage() > 0 ) {
            pager.setCurrentPage(page.getCurrentPage());
        }
        if(page.getPageSize() > 0 ) {
            pager.setPageSize(page.getPageSize());
        }


        List<Record> content = recordMapper.getRecordAll(pager);

        if((count % pager.getPageSize()) !=0){
            pager.setPageTotal((count / pager.getPageSize()) +1);
        } else {
            pager.setPageTotal( (count / pager.getPageSize()));
        }

        pager.setContent(content);

        //解决 JSONObject的 java.util.Date的转换
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

        JSONObject json = new JSONObject();

        return JSONObject.fromObject(pager,jsonConfig).toString();
    }

    /**
     * 添加领用记录
     * @param record
     * @return
     */

    public String insertRecord(Record record){

        System.out.println(record);
        Goods goods = new Goods();
        goods.setId(record.getGoodsId());

        System.out.println("goods " + goods);

        Integer recordResult = recordMapper.insertRecord(record);
        Integer goodsResult = goodsMapper.updateGoodsNum(record.getGoodsId(),record.getRecordNum());

        ReturnResult returnResult = null;
        if( recordResult > 0 && goodsResult > 0){

            returnResult = ReturnResult.result(1,"success","");

            return JSONObject.fromObject(returnResult).toString();
        }else {
            returnResult = ReturnResult.result(0,"false","");

            return JSONObject.fromObject(returnResult).toString();
        }
    }
}
