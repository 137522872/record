package com.hzbl360.controller;


import com.hzbl360.pojo.Goods;
import com.hzbl360.service.GoodsService;
import com.hzbl360.tools.Page;
import com.hzbl360.tools.ReturnResult;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    //添加物品(接口 添加数据)
    @CrossOrigin
    @RequestMapping(value = "/goods/insertGoods",method = RequestMethod.POST)
//    @ResponseBody
    public String insertGoods(@ModelAttribute("goods")Goods goods){
        System.out.println(goods);
        String result = goodsService.insertGoods(goods);
        System.out.println(result);

        //JSONObject jsonobject = JSONObject.fromObject(result);
        //ReturnResult returnResult = (ReturnResult) JSONObject.toBean(jsonobject, ReturnResult.class);
        return result;

    }


    //添加办公用品(视图)
    @CrossOrigin
    @RequestMapping(value = "/goods/insert")
    public String insert(){

        return "insertgoods";
    }


    //办公用品列表页
    @RequestMapping(value = "/goods/list",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String listPage(Page page){

        String allGoods = goodsService.getAllGoods(page);
        return allGoods;
    }


    /**
     * 更新物品信息
     * @param goods
     * @return
     */
    @RequestMapping("/goods/updateGoods")
    public String updateGoods(Goods goods){
        System.out.println(goods);
        ReturnResult returnResult = goodsService.updateGoods(goods);

        if(returnResult.getCode() != 0)
            return "redirect:/goods/list";

        return JSONObject.fromObject(returnResult).toString();
    }
}
