package com.ruida.springbootdemo.thread.pc;

/**
 * @description: 测试线程虚假唤醒
 * 将Clerk类中的while改为if即可实现虚假唤醒
 * 当一个条件满足时，很多线程都被唤醒了，但是只有其中部分是有用的唤醒，其它的唤醒都是无用功
 * 产生的原因：
 * 因为if只会执行一次，执行完会接着执行if()外边的；而while知道条件满足才会执行while()外边的
 * @author: chenjy
 * @create: 2021-01-04 17:18
 */
public class Test {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(producer,"生产者A").start();
        new Thread(consumer,"消费者A").start();
        new Thread(producer,"生产者B").start();
        new Thread(consumer,"消费者B").start();
    }
}
