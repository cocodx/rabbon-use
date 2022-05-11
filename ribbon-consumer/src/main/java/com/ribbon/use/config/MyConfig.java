package com.ribbon.use.config;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {

    //在获取restemplate去使用时，使用Ribbon能力进行调用
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //不允许配置多个负载均衡策略
    @Bean
    public RandomRule randomRule(){
        return new RandomRule();
    }
}
