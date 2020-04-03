package com.ruida.springbootdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 时间工具类
 * @author: chenjy
 * @create: 2020-04-01 17:35
 */
public class TimeUtil {
    public static final String FORMAT = "yyyy-MM-dd";

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
        System.out.println(sdf.format(new Date()));
        Date date = new Date();
        System.out.println(date.getTime());
    }

}
