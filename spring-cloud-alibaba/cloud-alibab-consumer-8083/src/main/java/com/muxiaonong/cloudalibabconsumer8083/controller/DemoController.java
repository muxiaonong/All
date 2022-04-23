package com.muxiaonong.cloudalibabconsumer8083.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * @program: spring-cloud-alibaba
 * @ClassName DemoController
 * @description:
 * @author: 牧小农
 * @create: 2022-04-04 16:11
 * @Version 1.0
 **/
@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 消费者去访问具体服务，这种写法可以实现
     * 配置文件和代码的分离
     */
    @Value("${service-url.nacos-user-service}")
    private String serverURL;


    @GetMapping(value = "/consumer/nacos")
    public String getDiscovery(){
        System.out.println(serverURL);
        return restTemplate.getForObject(serverURL+"/muxiaonong",String.class);
    }
}