package com.example.cloudalibabasentinel8006.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.cloudalibabasentinel8006.controller.handler.SentinelExptioinHandler;
import com.example.cloudalibabasentinel8006.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/fuse")
    public String fuse(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello fuse";
    }


    @GetMapping("/exptoin")
    public String exptoin(Integer id){
        if(id != null && id > 1){
            throw new RuntimeException("异常比例测试");
        }
        return "exptoin test";
    }

    @GetMapping("/exptoin/num")
    public String exptoinNum(Integer id){
        if(id != null && id > 1){
            throw new RuntimeException("异常数测试");
        }
        return "exptoinNum test";
    }

    @GetMapping("/hotTest")
    @SentinelResource(value = "hotTest",blockHandler = "handler_hot")
    public String testHotKey(@RequestParam(value = "v1",required = false) String v1,
                             @RequestParam(value = "v2",required = false)String v2){

        if("5".equals(v1)){
            throw new RuntimeException("报告有bug!!!");
        }
        return "热点规则 -  热点：";
    }

    //处理异常方法，方法签名要和对应的接口方法保持一致
    public String handler_hot(String v1, String v2, BlockException exception){
        return "请求过于频繁，请稍后再试.....";
    }


    @GetMapping("resourceTest")
    @SentinelResource(value = "resourceTest",blockHandler = "handler_resource")
    public String resourceTest(){
        return "resourceTest";
    }

    public String handler_resource(BlockException exception){
        return "系统繁忙，请稍后再试";
    }

    @GetMapping("/restUrl")
    @SentinelResource(value = "restUrl")
    public String restUrl(){
        return " restUrl";
    }


    /**
     * 此方法用到了自定义限流处理类型CustomerBlockHandler
     * 中的handlerException1方法来处理限流逻辑。
     */
    @GetMapping("/buildExption")
    @SentinelResource(value = "buildExption",
            blockHandlerClass = SentinelExptioinHandler.class,
            blockHandler = "handlerMethodError")
    public String buildExption(){
        return "hello buildExption";
    }

}
