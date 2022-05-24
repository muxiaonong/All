package com.example.cloudalibabasentinel8006.controller;

import com.example.cloudalibabasentinel8006.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/pay")
    public String pay() {
//        return "hello my name is pay ,wo shi boy";
        log.info("pay接口，请求线程为："+Thread.currentThread().getName());
        return testService.end();
    }

    @GetMapping("/order")
    public String order(){
//        return "hi my name is order, me is girl";
        return testService.end();
    }


}
