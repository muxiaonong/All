package com.muxiaonong.feign;

import com.muxiaonong.result.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 此接口就是配合使用OpenFeign的接口，
 * 1. 在此接口中添加@FeignClient接口同时标注
 * 2. 要调用的服务端名称，同时使用与服务提供者
 * 3. 方法签名一致的抽象方法来表示远程调用的
 */
@Service
@FeignClient("nacos-provider")
public interface GoodsFeign {

    @GetMapping("queryGoods/{id}")
    public Response<String> queryGoods(@PathVariable("id") Long id);

    @GetMapping("/readTimeOut")
    public String readTimeOut();
}
