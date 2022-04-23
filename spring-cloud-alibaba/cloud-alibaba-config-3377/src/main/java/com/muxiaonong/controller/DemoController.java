package com.muxiaonong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-cloud-alibaba
 * @ClassName DemoController
 * @description:
 * @author: 牧小农
 * @create: 2022-04-10 16:02
 * @Version 1.0
 **/
@RestController
@RefreshScope //支持Nacos的动态刷新功能
public class DemoController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }

}