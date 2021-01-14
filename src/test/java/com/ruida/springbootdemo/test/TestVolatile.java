package com.ruida.springbootdemo.test;

import java.util.concurrent.TimeUnit;

/**
 * @description: 测试volatile关键字
 * @author: chenjy
 * @create: 2021-01-04 09:07
 */
public class TestVolatile {

    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (flag){

            }
        }).start();

        TimeUnit.SECONDS.sleep(3);
        flag = false;

        //总结：volatile保证可见性，这样在一个线程上修改了共享变量，其他线程才能感知到
    }
}
