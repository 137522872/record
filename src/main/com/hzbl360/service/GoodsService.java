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

    public String getAllGoods(Integer currentPage,Integer pageSize){

        int count = goodsMapper.getCountGoods();

        Page<Goods> pager = new Page<>();


//        if(currentPage !=1 && currentPage >0) {
//            pager.setCurrentPage(currentPage);
//        }
//        if(pageSize !=2 && pageSize> 0) {
//            pager.setPageSize(pageSize);
//        }

        System.out.println(pager);
        List<Goods> content = goodsMapper.getAllGoods(pager);

        for(Goods goods:content){
            System.out.println(goods);
        }
        pager.setContent(content);

        return  JSONObject.fromObject(pager).toString();
    }
}
