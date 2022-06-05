package com.example.cloudalibabasentinel8006.controller.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 处理Sentinel限流自定义逻辑
 */
public class SentinelExptioinHandler {
    public static String handlerMethodError(BlockException exception){
        return "handlerMethodError：服务异常，请稍后重试！";
    }
    public static String handlerMethodNetwork(BlockException exception){
        return "handlerMethodNetwork：网络错误，连接超时，请稍后重试！";
    }
}