package com.ruida.springbootdemo.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author chenjy
 * @date 2021/3/26
 */
public class MultiThreadRequest {

    static int count = 0;

    private static void request() {
        try {
            TimeUnit.MICROSECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (Object.class){
            count++;
        }

    }

    public static void main(String[] args) {
        int threadSize = 100;
        CountDownLatch latch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    request();
                }
                latch.countDown();
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("============" + count);
    }

}
