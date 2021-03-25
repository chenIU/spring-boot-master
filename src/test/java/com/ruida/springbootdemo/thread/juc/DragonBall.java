package com.ruida.springbootdemo.thread.juc;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author chenjy
 * @date 2021/3/25
 */
public class DragonBall {

    private static final Random random = new Random();

    static class SearchTask implements Runnable{

        private int id;

        private CountDownLatch latch;

        public SearchTask(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("开始寻找：" + id + "号龙珠");
            int seconds = random.nextInt(10);
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("花了" + seconds + "s找到了" + id + "号龙珠");
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        List<Integer> idList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        CountDownLatch latch = new CountDownLatch(idList.size());
        for (Integer id : idList){
            new Thread(new SearchTask(id,latch)).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("找到所有龙珠，完成任务!!!");
    }
}
