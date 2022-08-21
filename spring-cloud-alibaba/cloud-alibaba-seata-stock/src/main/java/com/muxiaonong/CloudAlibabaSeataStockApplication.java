package com.muxiaonong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//添加此注解
public class CloudAlibabaSeataStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaSeataStockApplication.class, args);
    }

}
