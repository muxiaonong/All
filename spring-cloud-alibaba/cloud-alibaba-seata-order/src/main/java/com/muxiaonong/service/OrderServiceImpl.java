package com.muxiaonong.service;

import com.muxiaonong.client.StockClient;
import com.muxiaonong.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StockClient stockClient;

    @Override
    public void create() {
        //扣减库存
        stockClient.reduce();
        System.out.println("扣减库存成功！");

        //手工异常
        int i = 1/0;
        System.err.println("异常！");

        //创建订单
        orderMapper.createOrder();
        System.out.println("创建订单成功！");
    }
}
