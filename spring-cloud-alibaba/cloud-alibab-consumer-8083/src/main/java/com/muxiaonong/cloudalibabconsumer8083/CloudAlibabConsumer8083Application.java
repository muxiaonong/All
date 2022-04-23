package com.muxiaonong.cloudalibabconsumer8083;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabConsumer8083Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabConsumer8083Application.class, args);
    }

    @Bean
    @LoadBalanced //nacos集成了ribbon
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
