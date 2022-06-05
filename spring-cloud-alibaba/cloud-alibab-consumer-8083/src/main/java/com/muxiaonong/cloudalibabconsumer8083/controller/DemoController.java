package com.muxiaonong.cloudalibabconsumer8083.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.muxiaonong.cloudalibabconsumer8083.feign.FeignService;
import com.muxiaonong.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
/**
 * @program: spring-cloud-alibaba
 * @ClassName DemoController
 * @description:
 * @author: 牧小农
 * @create: 2022-04-04 16:11
 * @Version 1.0
 **/
@RestController
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 消费者去访问具体服务，这种写法可以实现
     * 配置文件和代码的分离
     */
    @Value("${service-url.nacos-user-service}")
    private String serverURL;


    @GetMapping(value = "/consumer/nacos")
    public String getDiscovery(){
        System.out.println(serverURL);
        return restTemplate.getForObject(serverURL+"/muxiaonong",String.class);
    }

    @GetMapping("/consumer/goods/{id}")
    //添加SentinelResource注解的fallback属性，同时设置方法来解决Java异常
    @SentinelResource(value = "falllback",fallback = "fallbackHandler",blockHandler = "blockHandler",
            exceptionsToIgnore = {NullPointerException.class})//被标注的异常将会被 原样抛出
    public Response<String> fallback(@PathVariable Long id){
        //通过Ribbon发起远程访问，访问9003/9004
        if(id <= 3) {
            Response<String> result = restTemplate.getForObject(serverURL + "/queryGoods/" + id, Response.class);
            return result;
        }else {
            throw new NullPointerException("未查询到对应的数据");
        }
    }

    //保证方法签名基本保持一致，但是要添加异常类型参数
    public Response<String> fallbackHandler(Long id,Throwable e){
        Response<String> result = new Response<>(500,"出现未知商品id","商品不存在");
        return result;
    }

    //处理Sentinel限流
    public Response<String> blockHandler(Long id, BlockException e){
        Response<String> result = new Response<>(501,"sentinel限流操作","blockHandler 限流");
        return result;
    }

    @Autowired
    private FeignService feignService;

    @GetMapping("queryGoods/{id}")
    public Response<String> getInfo(@PathVariable("id") Long id){
        if(id > 3){
            throw new RuntimeException("商品信息不存在："+id);
        }
        return feignService.queryGoods(id);
    }

}