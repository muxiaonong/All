package com.muxiaonong;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//添加此注解
public class CloudAlibabaOpenFeign8009Application {

	public static void main(String[] args) {
		SpringApplication.run(CloudAlibabaOpenFeign8009Application.class, args);
	}

	@Bean
	Logger.Level feignLoggerLevel(){
		//开启全日志
		return Logger.Level.FULL;
	}
}
