package com.ruida.springbootdemo.thread.callable;

/**
 * @description:
 * 继承自Thread或实现Runable接口的线程在执行后没有返回值，没有参数，没法抛出异常。
 * @author: chenjy
 * @create: 2020-11-25 17:21
 */
public class ThreadExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        t.start();
        System.out.println(Thread.currentThread().getName());
    }
}
