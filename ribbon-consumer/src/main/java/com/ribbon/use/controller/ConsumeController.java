package com.ribbon.use.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumeController {

    //Ribbon的负载均衡工具，使用这个对象可以使用Ribbon功能
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/consumer")
    public String consume(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("RIBBON-PRODUCE");
        System.out.println("getHost:"+serviceInstance.getHost());
        System.out.println("getInstanceId:"+serviceInstance.getInstanceId());
        System.out.println("getServiceId:"+serviceInstance.getServiceId());
        System.out.println("getMetadata:"+serviceInstance.getMetadata());
        System.out.println("getPort:"+serviceInstance.getPort());
        System.out.println("getScheme:"+serviceInstance.getScheme());
        System.out.println("getUri:"+serviceInstance.getUri());

        //模板方法
        System.out.println(restTemplate.getForObject("http://RIBBON-PRODUCE/produce/get",String.class));
        return null;
    }
}
