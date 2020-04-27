package com.ruida.springbootdemo.singleton;

/**
 * @description: 懒汉模式
 * 线程不安全，延迟初始化，严格意义上不是不是单例模式
 * @author: chenjy
 * @create: 2020-04-24 15:16
 */
public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

}
