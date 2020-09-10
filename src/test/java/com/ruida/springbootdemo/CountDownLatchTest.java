package com.ruida.springbootdemo;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(5);


    static class BossThread extends Thread{

        @Override
        public void run() {
            System.out.println("Boss在会议室等待，总共有"+countDownLatch.getCount()+"个人来开会...");
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("人到齐了,可以开会了...");
        }
    }

    static class EmployeeThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("员工:"+Thread.currentThread().getName()+",进入房间");
            countDownLatch.countDown();

        }
    }

    public static void main(String[] args) {

        new BossThread().start();

        for(int i =0;i<countDownLatch.getCount();i++){
            new EmployeeThread().start();
        }

    }
}
