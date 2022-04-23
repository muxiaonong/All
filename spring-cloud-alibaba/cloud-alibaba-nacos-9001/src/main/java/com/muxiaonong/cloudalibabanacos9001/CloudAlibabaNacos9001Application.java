package com.muxiaonong.cloudalibabanacos9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //需要添加这个注解
public class CloudAlibabaNacos9001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacos9001Application.class, args);
    }

}
