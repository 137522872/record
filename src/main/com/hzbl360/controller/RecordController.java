package com.hzbl360.controller;

import com.hzbl360.pojo.Record;
import com.hzbl360.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/all")
    public String getRecordAll(Map<String,Object> map){

        List<Record> recordAll = recordService.getRecordAll();

        map.put("allRecord",recordAll);

        for(Record record:recordAll){
            System.out.println(record);
        }
        return "goodslist";
    }
}
