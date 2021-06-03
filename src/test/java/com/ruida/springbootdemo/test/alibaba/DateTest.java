package com.ruida.springbootdemo.test.alibaba;

import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
}
