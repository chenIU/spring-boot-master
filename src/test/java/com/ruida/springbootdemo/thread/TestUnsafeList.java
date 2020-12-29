package com.ruida.springbootdemo.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @desc 证明ArrayList不是线程安全的
 * @author chenjy
 * @since 2020/12/26 22:26
 */
public class TestUnsafeList {

//    private static List<Integer> list = new ArrayList<>();
    private static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }

            for (Integer i : list){
                System.out.println("线程:" + Thread.currentThread().getName() + "-" + i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                list.add(i);
            }

            for (Integer i : list){
                System.out.println("线程:" + Thread.currentThread().getName() + "-" + i);
            }
        }).start();

        System.out.println(Thread.currentThread().getName());

    }
}
