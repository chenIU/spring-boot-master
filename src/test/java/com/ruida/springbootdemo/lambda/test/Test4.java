package com.ruida.springbootdemo.lambda.test;

/**
 * @description: lambda表达式创建线程
 * @author: chenjy
 * @create: 2020-04-24 14:30
 */
public class Test4 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t = new Thread(()->{
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"::"+i);
            }
        });
        t.start();
    }
}
