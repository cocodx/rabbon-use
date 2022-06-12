package com.ribbon.use.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author amazfit
 * @date 2022-06-12 下午1:05
 **/
@Configuration
public class FilterConfig {

//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder){
//        return builder.routes().route(r->r
//                .path("/produce/**")
//                .uri("http://localhost:8965/**")
//                .filter(new MyCustomerGatewayFilter())
//                .id("myCustomGateway")
//        ).build();
//    }
}
