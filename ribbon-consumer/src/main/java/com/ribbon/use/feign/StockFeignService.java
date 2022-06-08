package com.ribbon.use.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@FeignClient("ribbon-produce")
public interface StockFeignService {

    @RequestMapping("/produce/commonconfig1")
    public String test(@RequestParam("info") String info);
}
