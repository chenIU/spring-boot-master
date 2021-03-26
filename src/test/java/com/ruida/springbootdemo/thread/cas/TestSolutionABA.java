package com.ruida.springbootdemo.thread.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author chenjy
 * @date 2021/3/26
 */
public class TestSolutionABA {

    static AtomicStampedReference<Integer> a = new AtomicStampedReference<>(1, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("操作线程:" + Thread.currentThread().getName() + ",初始值=" + a.getReference());
            try {
                Integer expectReference = a.getReference();
                Integer newReference = expectReference + 1;
                int expectStamp = a.getStamp();
                int newStamp = expectStamp + 1;
                Thread.sleep(1000);//主线程休眠一秒钟，让出cpu

                boolean success = a.compareAndSet(expectReference, newReference, expectStamp, newStamp);
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",CAS操作:" + success);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "主线程").start();

        new Thread(() -> {
            try {
                Thread.sleep(20);

                a.compareAndSet(a.getReference(), a.getReference() + 1, a.getStamp(), a.getStamp() + 1);
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",[increment],值=" + a.getReference());
                a.compareAndSet(a.getReference(), a.getReference() - 1, a.getStamp(), a.getStamp() + 1);
                System.out.println("操作线程:" + Thread.currentThread().getName() + ",[decrement],值=" + a.getReference());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "干扰线程").start();
    }
}
