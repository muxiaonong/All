package com.example.cloudalibabasentinel8006.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @GetMapping("/playA")
    public String playA() {
        try {
            //阻塞1 秒
            TimeUnit.MILLISECONDS.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "hello my name is playA ,wo shi boy";
    }

    @GetMapping("/playB")
    public String playB(){
        return "hi my name is playB me girl";
    }


}
