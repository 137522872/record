package com.hzbl360.mapper;


import com.hzbl360.pojo.Goods;
import com.hzbl360.tools.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 */
@Repository
public interface GoodsMapper {

    //添加物品
    public Integer insertGoods(Goods goods);


    //获取办公用品(办公用品详情页)
    public List<Goods>  getAllGoods(Page page);

    //获取总记录数
    public Integer getCountGoods();
}
