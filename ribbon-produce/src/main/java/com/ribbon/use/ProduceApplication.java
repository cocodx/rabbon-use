package com.ribbon.use;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@RestController
public class ProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduceApplication.class,args);
    }

    @RequestMapping("/beat")
    public String beat(){
        return "I am healthy";
    }
}
