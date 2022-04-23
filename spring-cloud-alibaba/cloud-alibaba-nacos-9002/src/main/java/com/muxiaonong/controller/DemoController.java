package com.muxiaonong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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
public class DemoController {


    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/muxiaonong")
    public String getServerPort(){
            return "hello Nacos Discovery"+serverPort;
    }



}