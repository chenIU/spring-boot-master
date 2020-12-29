package com.ruida.springbootdemo.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * Thread的join()方法保证子线程执行完毕之后再执行主线程，但是这种方法不灵活。实际开发中一般使用CountDownLatch的countDown()，
 * 后者可以在子线程的任何地方调用，而不用像jon()只能在子线程的最后调用。
 * @author: chenjy
 * @create: 2020-11-26 09:23
 */
@Slf4j
public class ThreadJoinExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            log.info(Thread.currentThread().getName() + "执行完毕");
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            log.info(Thread.currentThread().getName() + "执行完毕");
        });
        thread2.start();

        thread1.join();
        thread2.join();

        log.info("主线程执行完毕");

    }
}
