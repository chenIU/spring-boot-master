package com.ruida.springbootdemo.test;

import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author chenjy
 * @since 2020/12/27 22:02
 */
public class SimpleDateFormatConcurrentTest {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(threadLocal.get());
                try {
                    System.out.println(threadLocal.get().parse("2020-12-27 22:05:02"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(threadLocal.get().parse("2020-12-27 22:05:02"));
//                    sdf.parse("2020-12-27 22:05:02");
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
