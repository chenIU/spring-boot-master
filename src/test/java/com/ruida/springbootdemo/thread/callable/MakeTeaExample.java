package com.ruida.springbootdemo.thread.callable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-25 17:57
 */
@Slf4j
public class MakeTeaExample {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        FutureTask<String> ft2 = new FutureTask<>(new T2Task());

        FutureTask<String> ft1 = new FutureTask<>(new T1Task(ft2));

        es.submit(ft1);
        es.submit(ft2);

        es.shutdown();

    }

    static class T1Task implements Callable<String>{

        private FutureTask<String> ft2;

        public T1Task(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {
            log.info("T1洗水壶...");
            TimeUnit.SECONDS.sleep(1);

            log.info("T1烧开水...");
            TimeUnit.SECONDS.sleep(15);

            String result = ft2.get();
            log.info("T1 拿到了 T2 的{},开始泡茶...",result);
            return "T1: 上茶";
        }
    }

    static class T2Task implements Callable<String>{
        @Override
        public String call() throws Exception {
            log.info("T2洗茶壶...");
            TimeUnit.SECONDS.sleep(1);

            log.info("T2洗茶杯...");
            TimeUnit.SECONDS.sleep(2);

            log.info("T2拿茶叶...");
            TimeUnit.SECONDS.sleep(1);
            return "西湖龙井";
        }
    }
}
