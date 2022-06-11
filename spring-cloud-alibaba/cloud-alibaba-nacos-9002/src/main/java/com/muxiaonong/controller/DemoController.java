package com.muxiaonong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-alibaba
 * @ClassName DemoController
 * @description:
 * @author: 牧小农
 * @create: 2022-03-27 17:08
 * @Version 1.0
 **/
@RestController
@RequestMapping("/mxn")
public class DemoController {


    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/muxiaonong")
    public String getServerPort(){
            return "hello Nacos Discovery"+serverPort;
    }

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello world ，my port is ："+serverPort;
    }


    @GetMapping(value = "/order")
    public String order(){
        return "我是代码网关 - 编号 order "+serverPort;
    }

}