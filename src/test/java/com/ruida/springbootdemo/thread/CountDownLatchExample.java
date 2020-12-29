package com.ruida.springbootdemo.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description:
 * 多线程一般在执行比较耗时的情况下使用，因为CPU上下文切换也需要消耗时间
 * @author: chenjy
 * @create: 2020-11-26 10:17
 */
@Slf4j
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        //创建一个很大的arrayList
        for (int i = 0; i < 100; i++) {
            list.add("" + i);
        }

        //处理arrayList
        List<String> outcome = new ArrayList<>(list.size());
//        for (String str:list){
//            Thread.sleep(50);
//            outcome.add("java_" + str);
//        }

        //多线程处理
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        ExecutorService es = new ThreadPoolExecutor(3,10,1L, TimeUnit.SECONDS,new LinkedBlockingDeque<>(list.size()), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        for(String str:list){
            es.execute(() -> {
                outcome.add("java_"+str);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        es.shutdown();
        outcome.stream().forEach(System.out::println);
        log.info("主线程执行完毕");
        log.info("执行耗时：{} ms",System.currentTimeMillis() - start);
    }
}
