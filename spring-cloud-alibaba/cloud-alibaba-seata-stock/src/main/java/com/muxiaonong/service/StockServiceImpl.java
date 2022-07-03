package com.muxiaonong.service;

import com.muxiaonong.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{


    @Autowired
    StockMapper stockMapper;

    @Override
    public void reduce() {
        stockMapper.reduce();
    }
}
