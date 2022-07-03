package com.muxiaonong.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StockMapper {

    @Update("update t_stock set order_num = order_num - 1 where order_no = 1 ")
    void reduce();

}
