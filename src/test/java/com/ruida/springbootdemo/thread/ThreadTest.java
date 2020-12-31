package com.ruida.springbootdemo.thread;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 17:08
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        for(int i=1;i<=10;i++){
            final int tmp = i;
            Thread t = new Thread(()->{
                System.out.println(Thread.currentThread().getName() + tmp);
            },"线程" + i + " i=");
            t.start();
            t.join();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
