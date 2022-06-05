package com.muxiaonong.feign;

import com.muxiaonong.feign.impl.GoodsServiceImpl;
import com.muxiaonong.result.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Service
@FeignClient(value = "nacos-provider",fallback = GoodsServiceImpl.class)
public interface GoodsFeign {

    @GetMapping("queryGoods/{id}")
    public Response<String> queryGoods(@PathVariable("id") Long id);

    @GetMapping("/readTimeOut")
    public String readTimeOut();
}
