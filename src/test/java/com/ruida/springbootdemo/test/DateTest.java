package com.ruida.springbootdemo.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-30 10:57
 */
public class DateTest {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Date date1 = new Date(System.currentTimeMillis()+1000 * 60 * 60);
        System.out.println(date1);
    }

    @Test
    public void test(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(new Date()));
    }
}
