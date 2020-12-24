package com.ruida.springbootdemo.test.alibaba;

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
}
