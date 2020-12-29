package com.ruida.springbootdemo.thread.callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @description:
 * 主线程执行future.get()会阻塞自己，知道子进程执行完成
 * @author: chenjy
 * @create: 2020-11-25 17:31
 */
@Slf4j
public class FutureAndCallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();

        Callable<String> callable = () -> {
            log.info("进入到Callable");
            Thread.sleep(5000);
            return "Hello From Callable";
        };

        log.info("提交Callable到线程池");
        Future<String> future = es.submit(callable);

        log.info("主线程继续执行");

        log.info("主线程等待Callable执行结果");
        //如果子进程没有执行结束，则睡眠1s之后重新检查
        long startTime = System.nanoTime();
        while(!future.isDone()){
            log.info("Task is still executing...");
            Thread.sleep(1000);

            double elapsedTimeInSec = (System.nanoTime() - startTime)/1000000000.0;
            //如果子进程执行时间超过3s，则取消子进程的执行
            if(elapsedTimeInSec > 3){
                future.cancel(true);
            }
        }
        //通过isCancelled判断程序是否被取消
        if(!future.isCancelled()){
            String result = future.get();
            log.info("主线程获取到Callable执行结果:{}",result);
        }else {
            log.warn("子线程被取消");
        }

        es.shutdown();
    }
}
