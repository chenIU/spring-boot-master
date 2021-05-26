package com.ruida.springbootdemo.thread;

/**
 * @author chenjy
 * @date 2021/3/24
 */
public class MultiThreadCount1 {

    private static int count = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                synchronized (MultiThreadCount1.class) {
                    while (count <= 1000) {
                        System.out.println(Thread.currentThread().getName() + " " + count++);
                    }
                }
            }).start();
        }
    }
}
