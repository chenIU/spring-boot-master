package com.ruida.springbootdemo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author chenjy
 * @date 2021/3/12
 */
public class TestRunnable {

    /**
     * Runnable 开启线程是异步执行的
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("主线程开始...");

        new Thread(() -> {
            System.out.println("正在执行计算...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("计算完成...");
        }).start();

        System.out.println("主线程结束...");
    }
}
