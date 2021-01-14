package com.ruida.springbootdemo.singleton.common;

/**
 * @desc 懒汉式
 * @author chenjy
 * @since 2021/1/3 9:32
 */
public class Lazy {

    private Lazy(){
        System.out.println(Thread.currentThread().getName() + " ok");
    }

    private static Lazy instance;

    public static Lazy getInstance(){
        if(instance == null){
            instance = new Lazy();
        }
        return instance;
    }

    //单线程下没问题,多线程下有问题
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Lazy.getInstance();
            }).start();
        }
    }
}
