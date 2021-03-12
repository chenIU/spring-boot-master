package com.ruida.springbootdemo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author chenjy
 * @date 2021/3/12
 */
public class TestFutureTask {

    /**
     * Callable和Runnable的区别
     *
     * Runnable run方法是被线程调用的，在run方法是异步执行的
     *
     * Callable的call方法，不是异步执行的，是由Future的run方法调用的
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            System.out.println("正在执行计算...");
            TimeUnit.SECONDS.sleep(3);
            return 1;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        System.out.println("干点别的...");
        thread.start();
        System.out.println("拿到的结果..." + futureTask.get());
    }
}
