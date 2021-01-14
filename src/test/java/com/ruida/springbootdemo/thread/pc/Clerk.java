package com.ruida.springbootdemo.thread.pc;

/**
 * @description: 店员
 * @author: chenjy
 * @create: 2021-01-04 17:09
 */
public class Clerk {

    private int product;

    public synchronized void add(){
        while (product >= 1){
            System.out.println(Thread.currentThread().getName() + "：已满！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ++product;
        System.out.println(Thread.currentThread().getName() + ".....进货成功,剩下:" + product);
        this.notifyAll();
    }

    public synchronized void sale(){
        while (product <= 0){
            System.out.println(Thread.currentThread().getName() + "：没有买到货！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        --product;
        System.out.println(Thread.currentThread().getName() + ".....买到了货物,剩下:" + product);
        this.notifyAll();
    }
}
