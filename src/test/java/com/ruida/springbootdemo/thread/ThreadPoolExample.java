package com.ruida.springbootdemo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * 不能使用Executors创建线程池
 * 原因：
 * 1.传入的workQueue是一个边界为Integer.MAX_VALUE的队列，可以认为是无界队列，比较消耗内存；
 * 2.拒绝策略是默认的拒绝策略，不是所有的业务场景都适用。
 * @author: chenjy
 * @create: 2020-11-26 09:31
 */
public class ThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();

        es.execute(() -> System.out.println(Thread.currentThread().getName()));

        es.shutdown();

        System.out.println(Thread.currentThread().getName());

    }
}
