package com.ribbon.use.dao;

import com.ribbon.use.entity.LeafAlloc;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeafAllocMapper {

    void insert(LeafAlloc leafAlloc);
}
