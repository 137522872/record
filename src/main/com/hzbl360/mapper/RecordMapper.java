package com.hzbl360.mapper;


import com.hzbl360.pojo.Record;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */

@Repository
public interface RecordMapper {

    //通过物品id 查询领用记录
    public List<Record> getRecordByGoodsId(Integer goodsId);

    //列出所有未归还的领用记录
    public List<Record> getRecordAll();
}
