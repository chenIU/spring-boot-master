package com.ruida.springbootdemo.thread;

import java.util.concurrent.*;

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
    }
}
