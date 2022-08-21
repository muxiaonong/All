package com.muxianong.cloudalibabaprovider9003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProvider9003Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProvider9003Application.class, args);
    }

}
