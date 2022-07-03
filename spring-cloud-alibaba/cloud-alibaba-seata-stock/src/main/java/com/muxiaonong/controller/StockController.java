package com.muxiaonong.controller;


import com.muxiaonong.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("stock/reduce")
    public String reduce(){
        stockService.reduce();
        return "库存数量已扣减："+ new Date();
    }

}
