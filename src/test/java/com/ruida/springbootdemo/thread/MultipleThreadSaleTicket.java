package com.ruida.springbootdemo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 多线程卖票问题(待解决问题 有时候会多出一张)
 * @author: chenjy
 * @create: 2020-12-31 15:29
 */
public class MultipleThreadSaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket, "售票窗口一").start();
        new Thread(ticket, "售票窗口二").start();
    }
}

class Ticket implements Runnable {

    int count = 50;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (count > 0) {
            lock.lock();
            try {
                sale();
            } finally {
                lock.unlock();
            }
        }
    }

    // 不加锁版本
//    public void sale(){
//        System.out.println(Thread.currentThread().getName() + "售出第" + (50 - count + 1) + "张票");
//        count --;
//    }


    //synchronized版本
//    public synchronized void sale(){
//        System.out.println(Thread.currentThread().getName() + "售出第" + (50 - count + 1) + "张票");
//        count --;
//    }

    //lock版本
    public void sale() {
        System.out.println(Thread.currentThread().getName() + "售出第" + (50 - count + 1) + "张票");
        count--;
    }
}
