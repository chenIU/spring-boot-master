package com.ruida.springbootdemo.thread;

/**
 * @author chenjy
 * @date 2021/3/24
 */
public class MultiThreadCount3 {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }, "Thread-A");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }, "Thread-B");
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }
}
