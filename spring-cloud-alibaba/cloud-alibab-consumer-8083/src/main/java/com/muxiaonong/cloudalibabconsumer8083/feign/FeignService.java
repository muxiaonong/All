package com.muxiaonong.cloudalibabconsumer8083.feign;


import com.muxiaonong.cloudalibabconsumer8083.feign.impl.FeignServiceImpl;
import com.muxiaonong.result.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "nacos-provider",fallback = FeignServiceImpl.class)
public interface FeignService {

    @GetMapping("queryGoods/{id}")
    public Response<String> queryGoods(@PathVariable("id") Long id);

}
