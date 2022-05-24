package com.example.cloudalibabasentinel8006.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    // 定义限流资源
    @SentinelResource("end")
    public String end(){
        return "end method";
    }

}
