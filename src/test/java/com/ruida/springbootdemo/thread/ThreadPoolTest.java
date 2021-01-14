package com.ruida.springbootdemo.thread;


import org.junit.Test;
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

    @Test
    public void test0(){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,
                5,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 9; i++) {
            pool.execute(()-> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        /**
         * 总结
         * corePoolSize(核心线程数)：正常工作的线程，当队列中没有排队的线程时，一直是核心线程在工作
         * maximumPoolSize(最大线程数)：当任务队列中有新的任务时，工作线程可是扩大，但是最大值不能超过最大线程数
         * keepAliveTime(存活时间)：当任务量减少时，工作线程数量会向核心线程靠拢，临时增加的工作线程数量会减少。此值设置了过多长时间这些临时增加的线程会消失
         * unit(时间单位)：临时增加的线程消失的时间单位
         * workQueue(工作队列)：存放超出的任务
         * threadFactory：线程工厂
         * handler：拒绝策略
         */
    }
}
