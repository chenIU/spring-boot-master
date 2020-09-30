package com.ruida.springbootdemo.thread;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 17:08
 */
public class ThreadTest {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
