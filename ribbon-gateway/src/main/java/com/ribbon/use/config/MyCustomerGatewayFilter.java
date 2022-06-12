package com.ribbon.use.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author amazfit
 * @date 2022-06-12 下午12:24
 **/
public class MyCustomerGatewayFilter implements GatewayFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("自定义网关过滤器");
        System.out.println(exchange.getRequest().getRemoteAddress());
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
