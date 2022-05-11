package com.ribbon.use.controller;

import com.ribbon.use.dao.LeafAllocMapper;
import com.ribbon.use.entity.LeafAlloc;
import com.ribbon.use.model.CommonResult;
import com.ribbon.use.model.Constants;
import com.ribbon.use.model.StepModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 注意单线程，写法
 */
@RestController
@RequestMapping("/leaf")
public class LeafController {

    @Autowired
    private LeafAllocMapper leafAllocMapper;

    ConcurrentHashMap<String,StepModel> leafSpring = new ConcurrentHashMap<>();

    @RequestMapping("/get")
    public Object getTagId(@RequestParam("key")String key){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(200);
        int i = leafAllocMapper.selectCountByKey(key);
        LeafAlloc leafAlloc;
        if (i<=0){
            //TODO 对key进行插入
            leafAlloc = new LeafAlloc();
            leafAlloc.setKey(key);
            leafAlloc.setStep(Constants.STEP_VALUE);
            leafAlloc.setMaxId(Constants.MAX_ID_VALUE);
            leafAlloc.setDescription("非必要注释");
            leafAllocMapper.insert(leafAlloc);
            StepModel stepModel = new StepModel();
            stepModel.setStep(Constants.STEP_VALUE);
            stepModel.setMinId(new AtomicLong(0L));
            stepModel.setMaxId(new AtomicLong(Constants.MAX_ID_VALUE));
            leafSpring.put(key,stepModel);
        }else{
            //取号，取1000，就是把maxId更新1000。更新之后再查一下
            StepModel stepModel = new StepModel();
            leafAlloc = leafAllocMapper.selectEntityByKey(key);
            AtomicLong minId = new AtomicLong(leafAlloc.getMaxId());
            leafAlloc.setStep(Constants.STEP_VALUE);
            leafAllocMapper.update(leafAlloc);
            AtomicLong maxId = new AtomicLong(leafAlloc.getMaxId()+Constants.STEP_VALUE);
            stepModel.setMinId(minId);
            stepModel.setMaxId(maxId);
            stepModel.setStep(Constants.STEP_VALUE);
            leafSpring.put(key,stepModel);
        }
        //TODO 取号返回
        //TODO 取号更新操作
        if (leafSpring.containsKey(key)){
            StepModel stepModel = leafSpring.get(key);
            if (stepModel.getMinId().incrementAndGet()<= stepModel.getMaxId().get()){
                commonResult.setData(stepModel.getMinId().get());
                return commonResult;
            }else{
                //TODO 更新步长再去返回
                StepModel updateModel = new StepModel();
                leafAlloc = leafAllocMapper.selectEntityByKey(key);
                AtomicLong minId = new AtomicLong(leafAlloc.getMaxId());
                leafAlloc.setStep(Constants.STEP_VALUE);
                leafAllocMapper.update(leafAlloc);
                AtomicLong maxId = new AtomicLong(leafAlloc.getMaxId()+Constants.STEP_VALUE);
                updateModel.setMinId(minId);
                updateModel.setMaxId(maxId);
                updateModel.setStep(Constants.STEP_VALUE);
                leafSpring.put(key,stepModel);
                commonResult.setData(stepModel.getMinId().get());
                return commonResult;
            }
        }
        return commonResult;
    }

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
