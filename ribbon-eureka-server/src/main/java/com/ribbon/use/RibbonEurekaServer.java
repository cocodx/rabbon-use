package com.ribbon.use;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class RibbonEurekaServer {

    public static void main(String[] args) {
        SpringApplication.run(RibbonEurekaServer.class,args);
    }
}
