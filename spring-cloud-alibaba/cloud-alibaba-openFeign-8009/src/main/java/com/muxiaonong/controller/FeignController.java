package com.muxiaonong.controller;

import com.muxiaonong.feign.GoodsFeign;
import com.muxiaonong.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FeignController {

    @Autowired
    private GoodsFeign goodsFeign;

    @GetMapping("query/{id}")
    public Response<String> query(@PathVariable("id") Long id){
        return goodsFeign.queryGoods(id);
    }


    @GetMapping("/query/readTimeOut")
    public String readTimeOut() {
        String str = goodsFeign.readTimeOut();
        return str;
    }

}
