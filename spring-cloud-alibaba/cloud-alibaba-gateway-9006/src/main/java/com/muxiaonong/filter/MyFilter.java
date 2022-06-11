package com.muxiaonong.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Slf4j
@Component
public class MyFilter implements Ordered, GlobalFilter {
    /**
     * @param exchange 可以拿到对应的request和response
     * @param chain 过滤器链
     * @return 是否放行
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取第一个参数
        String id = exchange.getRequest().getQueryParams().getFirst("id");
        //打印当前时间
        log.info("MyFilter 当前请求时间为:"+new Date());
        //判断用户是否存在
        if(StringUtils.isEmpty(id)){
            log.info("用户名不存在，非法请求！");
            //如果username为空，返回状态码为407，需要代理身份验证
            exchange.getResponse().setStatusCode(HttpStatus.PROXY_AUTHENTICATION_REQUIRED);
            // 后置过滤器
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 设定过滤器的优先级，值越小则优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}