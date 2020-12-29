package com.ruida.springbootdemo.thread;

import java.util.concurrent.*;

/**
 * corePoolSize：核心线程数
 * maximumPoolSize：最大线程数，当核心线程不足以处理任务时，可以创建新的线程来执行，但是最大线程不能超过此值
 * keepAliveTime：非核心线程的存活时间。当没有任务需要执行时，非核心线程超过此时间会自动销毁
 * TimeUnit：时间单位
 * BlockingQueue：任务等待队列
 * Executors.defaultThreadFactory()：线程工厂，创建非核心线程的工厂
 * ThreadPoolExecutor.AbortPolicy()：默认的拒绝策略，抛出异常
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for(int i=0;i<9;i++){
            executorService.execute(()-> System.out.println(Thread.currentThread().getName()+"执行业务"));
        }
        executorService.shutdown();
    }
}
