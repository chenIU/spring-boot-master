package com.ruida.springbootdemo.thread.callable;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-25 17:24
 */
public class CallableExample {
    public static void main(String[] args) throws Exception {
        Callable<String> callable = () -> {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
            return "Hello From Callable";
        };
        System.out.println(callable.call());
        System.out.println(Thread.currentThread().getName());
    }
}
