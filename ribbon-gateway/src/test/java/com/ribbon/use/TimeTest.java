package com.ribbon.use;


import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeTest {

    /**
     * 获取ZonedDateTime类型的指定日期时间
     */
    @Test
    public void testZonedDateTime(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();//默认时区
        //用指定时区获取时间
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
    }
}
