package com.muxiaonong.feign.impl;

import com.muxiaonong.feign.GoodsFeign;
import com.muxiaonong.result.Response;
import org.springframework.stereotype.Component;

@Component
public class GoodsServiceImpl implements GoodsFeign {

    @Override
    public Response<String> queryGoods(Long id) {
        return new Response<>(501,"服务降级处理返回信息",null);
    }

    @Override
    public String readTimeOut() {
        return null;
    }
}
