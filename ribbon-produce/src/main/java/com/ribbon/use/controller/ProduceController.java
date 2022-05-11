package com.ribbon.use.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProduceController {

    @Value("${server.port}")
    private Integer port;


    @RequestMapping("/produce/get")
    public String getProduce(){
        return "{\"produceId\":"+ UUID.randomUUID() +",\"port\":"+port+"}";
    }
}
