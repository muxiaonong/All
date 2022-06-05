package com.muxiaonong.cloudalibabconsumer8083.feign.impl;

import com.muxiaonong.cloudalibabconsumer8083.feign.FeignService;
import com.muxiaonong.result.Response;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {

    @Override
    public Response<String> queryGoods(Long id) {
        return new Response<>(501,"服务降级处理",null);
    }
}
