package com.ruida.springbootdemo.entity.singleton;

/**
 * @description: 双重锁机制
 * 线程安全，延迟初始化。这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * @author: chenjy
 * @create: 2020-04-24 15:28
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if(instance == null){
            synchronized (Singleton3.class){
                if(instance == null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }

}
