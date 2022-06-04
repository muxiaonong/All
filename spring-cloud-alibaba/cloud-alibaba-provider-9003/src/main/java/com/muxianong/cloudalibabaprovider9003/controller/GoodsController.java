package com.muxianong.cloudalibabaprovider9003.controller;

import com.muxiaonong.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
public class GoodsController {


    @Value("${server.port}")
    private String serverPort;

    //模仿数据库存储数据
    public static HashMap<Long,String> hashMap = new HashMap<>();
    static {
        hashMap.put(1l,"面膜");
        hashMap.put(2l,"哈密瓜");
        hashMap.put(3l,"方便面");
    }

    @GetMapping("queryGoods/{id}")
    public Response<String> queryGoods(@PathVariable("id") Long id){
        Response<String> response = new Response(200,"成功请求："+serverPort,hashMap.get(id));
        return response;
    }


    @GetMapping("/readTimeOut")
    public String readTimeOut() {
        try {
            System.out.println(serverPort+"网络连接超时，延迟响应");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}