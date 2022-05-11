package com.ribbon.use;

import com.ribbon.use.dao.LeafAllocMapper;
import com.ribbon.use.entity.LeafAlloc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeafMapperTest {

    @Autowired
    LeafAllocMapper leafAllocMapper;

    @Test
    public void testMapperInsert(){
        LeafAlloc leafAlloc = new LeafAlloc();
        leafAlloc.setKey("cmail.ceshi");
        leafAlloc.setMaxId(100L);
        leafAlloc.setStep(1000);
        leafAlloc.setDescription("testtest");
        leafAllocMapper.insert(leafAlloc);
    }
}
