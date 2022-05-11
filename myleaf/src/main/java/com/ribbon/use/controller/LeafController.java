package com.ribbon.use.controller;

import com.ribbon.use.dao.LeafAllocMapper;
import com.ribbon.use.entity.LeafAlloc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leaf")
public class LeafController {

    @Autowired
    private LeafAllocMapper leafAllocMapper;

    @RequestMapping("/insert")
    public String insert(){
        LeafAlloc leafAlloc = new LeafAlloc();
        leafAlloc.setKey("11");
        leafAlloc.setMaxId(1L);
        leafAlloc.setStep(1000);
        leafAlloc.setDescription("test test");
        leafAllocMapper.insert(leafAlloc);
        return "";
    }
}
