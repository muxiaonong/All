//package com.muxiaonong.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GateWayConfig {
//
//      /*
//    配置了一个id为path_mxn的路由规则
//    当访问地址http://localhost:9999/mxn/**
//    就会转发到http://localhost:9001/nacos-provider/mxn/任何地址
//     */
//
//    @Bean
//    public RouteLocator gateWayConfigInfo(RouteLocatorBuilder routeLocatorBuilder){
//        // 构建多个路由routes
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        // 具体路由地址
//        routes.route("path_mxn",r -> r.path("/mxn/**").uri("http://localhost:9001/nacos-provider")).build();
//        // 返回所有路由规则
//        return routes.build();
//    }
//}
