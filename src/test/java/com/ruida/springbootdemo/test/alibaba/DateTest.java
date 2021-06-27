package com.ruida.springbootdemo.test.alibaba;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * M：表示月份
 * m：表示分钟
 * H：24小时制
 * h：12小时制
 * @author: chenjy
 * @create: 2020-12-07 11:20
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());

        int days = LocalDate.now().lengthOfYear();
        System.out.println(days);
    }

    @Test
    public void test1() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date date = format.parse("2021.5.9");
        System.out.println(date);
    }

    @Test
    public void test2(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(format.format(new Date()));
    }

    @Test
    public void test3(){
        System.out.println(DateUtil.year(new Date()));
    }

    /**
     * 测试hutool工具类计算两个时间的差值，不区分开始时间和结束时间
     */
    @Test
    public void testTimeBetween(){
        Date startTime = new Date();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR,3);
        Date endTime = instance.getTime();
        long between = DateUtil.between(startTime, endTime, DateUnit.MINUTE);
        System.out.println(between);
    }
}
