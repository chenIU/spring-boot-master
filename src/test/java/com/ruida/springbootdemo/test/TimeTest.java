package com.ruida.springbootdemo.test;

import cn.hutool.core.date.BetweenFormatter;
import cn.hutool.core.date.DateUtil;
import lombok.SneakyThrows;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

/**
 * @description: Java8日期时间API
 * 传统日期时间API的缺点：
 * 1.非线程安全（最大的问题）
 * 2.设计很差
 * 3.时区处理麻烦
 * @author: chenjy
 * @create: 2020-09-30 09:16
 */
public class TimeTest {

    public static void main(String[] args) {

        //本地化日期时间 API
        LocalDateTime current = LocalDateTime.now();
        System.out.println(current);

        LocalDate date1 = current.toLocalDate();
        System.out.println(date1);

        int month = current.getMonthValue();
        int day = current.getDayOfMonth();
        int second = current.getSecond();
        System.out.println("月:"+month+",日:"+day+",秒:"+second);

        LocalDateTime date2 = current.withDayOfMonth(10).withYear(2020);
        System.out.println(date2);

        //创造日期
        LocalDate date3 = LocalDate.of(2020,10,1);
        System.out.println(date3);

        //创造时间
        LocalTime date4 = LocalTime.of(23,59);
        System.out.println(date4);

        //解析字符串
        LocalTime date5 = LocalTime.parse("23:59:59");
        System.out.println(date5);


        System.out.println("-------------------");

        //使用时区的日期时间API
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println(currentZone);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println(id);

        ZonedDateTime date6 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println(date6);

        TimeTest.date2LocalDateTime();

    }

    public static void date2LocalDateTime(){
        System.out.println("===========date2LocalDateTime===========");
        Date date = new Date();
        System.out.println("Date:"+date);
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant,ZoneId.systemDefault());
        System.out.println("LocalDateTime:"+localDateTime);
    }

    @SneakyThrows
    @Test
    public void test(){
        long start = System.currentTimeMillis();
        Thread.sleep(1345);
        System.out.println(DateUtil.formatBetween(System.currentTimeMillis() - start, BetweenFormatter.Level.MILLISECOND));
    }

    @Test
    @SneakyThrows
    public void testTimeBeforeAfter(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse("2021-06-06");
        Date d2 = sdf.parse("2021-06-09");
        System.out.println(d1.before(d2));
        System.out.println(d2.after(d1));
    }
}
