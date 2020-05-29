package com.ruida.springbootdemo.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @description: LocalDateTime
 * @author: chenjy
 * @create: 2020-05-29 16:24
 * java.time包下的所有类都是不可变类型而且线程安全。
 */
public class LocalDateTimeUtil {
    public static void main(String[] args) {
        //获取当前日期
        LocalDate date = LocalDate.now();
        System.out.println(date);

        //获取年、月、日信息
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        System.out.printf("Year : %d  Month : %d  day : %d  %n", year, month, day);

        //创建指定日期
        LocalDate birthday = LocalDate.of(1994,04,18);
        System.out.println(birthday);

        //判断两个日期是否相等
        LocalDate today = LocalDate.of(2020,05,29);
        System.out.println(today.equals(date));

        //获取当前时间
        LocalTime time = LocalTime.now();
        System.out.println(time);

        //增加小时(LocalTime是不可变对象)
        LocalTime newTime = time.plusHours(2);
        System.out.println(newTime);

        //增加星期（ChronoUnit）
        LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
        System.out.println(nextWeek);

        //比较两个日期的顺序
        LocalDate day1 = LocalDate.of(2020,5,20);
        LocalDate day2 = LocalDate.of(2020,5,21);
        System.out.println(day1.isBefore(day2));

        //判断闰年
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println("This year is not a Leap year");
        }

        //时间戳
        Instant timestamp = Instant.now();
        System.out.println(timestamp);

        //日期和时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}
