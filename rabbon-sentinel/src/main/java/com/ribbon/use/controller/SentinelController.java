package com.ribbon.use.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amazfit
 * @date 2022-06-14 下午8:35
 **/
@RestController
public class SentinelController {

    @SentinelResource(value = "helloworld",blockHandler = "blockHandler")
    @RequestMapping("helloworld")
    public String helloworld(){
        return "Sentinel 注解方式："+System.currentTimeMillis();
    }

    public String blockHandler(){
        return "系统繁忙，请稍后!";
    }

}
