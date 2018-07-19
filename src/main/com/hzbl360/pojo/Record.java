package com.hzbl360.pojo;

import java.sql.Date;

public class Record {

    private Integer id;             //领用记录ID
    private String recordName;      //领用人姓名
    private Integer recordNum;      //领用数量
    private Integer recordStatus;   //领用状态 (0--归还,1--领用中)
    private Date recordDate;
    private Integer goodsId;
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public Integer getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(Integer recordNum) {
        this.recordNum = recordNum;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", recordName='" + recordName + '\'' +
                ", recordNum=" + recordNum +
                ", recordStatus=" + recordStatus +
                ", recordDate=" + recordDate +
                ", goodsId=" + goodsId +
                ", goods=" + goods +
                '}';
    }
}
