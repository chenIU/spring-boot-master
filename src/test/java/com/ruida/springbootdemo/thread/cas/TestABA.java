package com.ruida.springbootdemo.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenjy
 * @date 2021/3/26
 */
public class TestABA {

    static AtomicInteger a = new AtomicInteger(1);

    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("操作线程:" + Thread.currentThread().getName() + ",初始值=" + a.get());
            try {
                int expectNum = a.get();
                int newNum = expectNum + 1;
                Thread.sleep(1000);//主线程休眠一秒钟，让出cpu

                boolean success = a.compareAndSet(expectNum, newNum);
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",CAS操作:" + success);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"主线程").start();

        new Thread(() -> {
            try {
                Thread.sleep(20);//确保主线程先执行
                a.incrementAndGet();
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",[increment],值=" + a.get());
                a.decrementAndGet();
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",[decrement],值=" + a.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"干扰线程").start();
    }
}
