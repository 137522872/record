package com.hzbl360.controller;

import com.hzbl360.pojo.Record;
import com.hzbl360.service.RecordService;
import com.hzbl360.tools.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 *
 */

@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;


    //通过领用物品id查询领用记录
    @RequestMapping("/getRecordByGoodsId")
    public String getRecordByGoodsId(Integer goodsId){

        List<Record> recordById = recordService.getRecordByGoodsId(1);
        for(Record record:recordById){
            System.out.println(record);
        }
        return "goodslist";
    }


    //列出所有领用记录
    @RequestMapping(value = "/record/list",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String listPage(Page page){

        String recordAll = recordService.getRecordAll(page);
        return recordAll;

    }

    //添加领用记录
    @RequestMapping(value = "/record/insertRecord")
    @ResponseBody
    public String insertRecord(Record record){
        System.out.println(record);
        String s = recordService.insertRecord(record);
        return "";

    }
}
