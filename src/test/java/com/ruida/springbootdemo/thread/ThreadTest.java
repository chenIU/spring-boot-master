package com.ruida.springbootdemo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 17:08
 */
public class ThreadTest {

    static List<String> list = new ArrayList<>();

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

        //多线程访问共享资源会出现线程安全问题
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }).start();
        }
    }
}
