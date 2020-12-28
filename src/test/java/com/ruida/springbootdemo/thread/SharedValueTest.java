package com.ruida.springbootdemo.thread;

/**
 * @description: 共享变量多线程会遇到的问题
 * @author: chenjy
 * @create: 2020-12-28 13:12
 */
public class SharedValueTest {

    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    count++;
                }
            });
            thread.start();
//            thread.join();
        }
        System.out.println(count);
    }
}
