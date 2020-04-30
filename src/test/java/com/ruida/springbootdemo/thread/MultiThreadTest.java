package com.ruida.springbootdemo.thread;

/**
 * @description: 多线程测试
 * @author: chenjy
 * @create: 2020-04-24 14:57
 */
public class MultiThreadTest {
    public static void main(String[] args) {

        for(int i=0;i<10;i++){
            Thread t = new Thread(() ->{
                System.out.println(Thread.currentThread().getName());
            });
            t.start();
        }

    }
}
