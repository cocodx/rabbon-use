package com.ribbon.use.config;

//import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collections;

@Configuration
public class MyConfig {

    //在获取restemplate去使用时，使用Ribbon能力进行调用
//    @LoadBalanced
//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    //不允许配置多个负载均衡策略
//    @Bean
//    public RandomRule randomRule(){
//        return new RandomRule();
//    }

//    @Resource
//    LoadBalancerClient loadBalancer;
//
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setInterceptors(Collections.singletonList(new LoadBalancerInterceptor(loadBalancer)));
        return restTemplate;
    }
}
