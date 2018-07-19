package com.hzbl360.service;


import com.hzbl360.mapper.RecordMapper;
import com.hzbl360.pojo.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    //通过物品id查询领用记录
    public List<Record> getRecordByGoodsId(Integer goodsId){

        List<Record> recordById = recordMapper.getRecordByGoodsId(goodsId);

        return recordById;
    }

    //列出所有领用记录
    public List<Record> getRecordAll(){

        List<Record> recordAll = recordMapper.getRecordAll();
        return recordAll;
    }
}
