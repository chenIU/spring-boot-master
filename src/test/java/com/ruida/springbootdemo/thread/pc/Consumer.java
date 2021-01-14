package com.ruida.springbootdemo.thread.pc;

/**
 * @description: 消费者
 * @author: chenjy
 * @create: 2021-01-04 17:16
 */
public class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}
