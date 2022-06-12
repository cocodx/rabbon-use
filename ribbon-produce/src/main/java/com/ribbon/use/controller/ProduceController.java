package com.ribbon.use.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
//@RefreshScope//实时刷新配置
public class ProduceController {

    @Value("${server.port}")
    private Integer port;

    @Value("${java1234.name}")
    private String name;

    @Value("${java1234.age}")
    private Integer age;

//    @Value("${java1234.mysql.common}")
//    private String mysql;
//
//    @Value("${java1234.redis.common}")
//    private String redis;


    @RequestMapping("/produce/get")
    public String getProduce(String info){
        System.out.println(info);
        return "{\"produceId\":"+ UUID.randomUUID() +",\"port\":"+port+"}";
    }


    @RequestMapping("/produce/config")
    public String getConfig(){
        return "{\"name\":"+ name +",\"age\":"+age+"}";
    }


//    @RequestMapping("/produce/commonconfig")
//    public String getCommonConfig(){
//        return "{\"mysql\":"+ mysql +",\"redis\":"+redis+"}";
//    }

    @RequestMapping("/produce/commonconfig1")
    public String getCommonConfig1(@RequestParam("info")String info){
        return info;
    }
}
