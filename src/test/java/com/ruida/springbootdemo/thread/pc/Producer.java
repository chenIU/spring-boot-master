package com.ruida.springbootdemo.thread.pc;

import java.util.concurrent.TimeUnit;

/**
 * @description: 生产者
 * @author: chenjy
 * @create: 2021-01-04 17:14
 */
public class Producer implements Runnable{

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.add();
        }
    }
}
