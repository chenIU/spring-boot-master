package com.ruida.springbootdemo.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenjy
 * @date 2021/3/24
 */
public class MultiThreadCount2 {

    private static final AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (count.get() <= 1000){
                    System.out.println(Thread.currentThread().getName() + " " + count.getAndIncrement());
                }
            }).start();
        }
    }
}
