package com.ribbon.use.dao;

import com.ribbon.use.entity.LeafAlloc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LeafAllocMapper {

    void insert(LeafAlloc leafAlloc);

    int selectCountByKey(@Param("key") String key);
}
