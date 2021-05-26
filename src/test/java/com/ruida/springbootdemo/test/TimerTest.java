package com.ruida.springbootdemo.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Chen.J.Y
 * @date 2021/5/22
 */
public class TimerTest {

    private static final Timer timer = new Timer(true);

    public static void main(String[] args) {
        System.out.println("主线程执行...");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("调度线程执行...");
            }
        },60 * 1000);
    }
}
