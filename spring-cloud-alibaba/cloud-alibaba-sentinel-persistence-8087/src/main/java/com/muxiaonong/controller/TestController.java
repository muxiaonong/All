package com.muxiaonong.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    @SentinelResource(value = "test")
    public String test(){
        return "hello world";
    }

}
