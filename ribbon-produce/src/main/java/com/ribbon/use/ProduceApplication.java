package com.ribbon.use;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableDiscoveryClient //开启服务注册与发现功能，classpath:META-INF/spring.factories文件
@SpringBootApplication
@RestController
public class ProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduceApplication.class,args);
    }

     public String beat(){
        return "I am healthy";
    }
}
