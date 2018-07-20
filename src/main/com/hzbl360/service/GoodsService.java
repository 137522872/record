package com.hzbl360.service;


import com.hzbl360.mapper.GoodsMapper;
import com.hzbl360.pojo.Goods;
import com.hzbl360.tools.Page;
import com.hzbl360.tools.ReturnResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public String insertGoods(Goods goods) {

        ReturnResult returnResult = null;
        System.out.println(goods +": GoodsService");
        System.out.println(goods.getGoodsNum()+" :getGoodsNum");
        System.out.println(goods.getGoodsTotal()+ ": GETgOODStOTAL");
        if (goods.getGoodsNum() > 0 && goods.getGoodsTotal() > 0) {
            System.out.println("integer" + ".....insert");
            Integer integer = goodsMapper.insertGoods(goods);

            if (integer > 0) {
                returnResult = ReturnResult.result(integer, "添加成功", "");
            } else {
                returnResult = ReturnResult.result(integer, "添加失败", "");
            }

            return JSONObject.fromObject(returnResult).toString();
        }else {
            returnResult = ReturnResult.result(0, "物品总数量和可以领用数量不能小于0", "");
            return JSONObject.fromObject(returnResult).toString();
        }
    }

    public String getAllGoods(Page page){

        int count = goodsMapper.getCountGoods();

        Page<Goods> pager = new Page<>();


        if(page.getCurrentPage() >0) {
            pager.setCurrentPage(page.getCurrentPage());
        }
        if(page.getPageSize() >0) {
            pager.setPageSize(page.getPageSize());
        }


        List<Goods> content = goodsMapper.getAllGoods(pager);

        if((count % pager.getPageSize()) !=0){
            pager.setPageTotal((count / pager.getPageSize()) +1);
        } else {
            pager.setPageTotal( (count / pager.getPageSize()));
        }

        pager.setContent(content);
        return  JSONObject.fromObject(pager).toString();
    }
}
