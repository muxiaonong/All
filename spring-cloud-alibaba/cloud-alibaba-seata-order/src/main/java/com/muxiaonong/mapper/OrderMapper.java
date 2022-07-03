package com.muxiaonong.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    @Insert("insert into t_order (order_no,order_num) value (order_no+1,1)")
    void createOrder();

}
