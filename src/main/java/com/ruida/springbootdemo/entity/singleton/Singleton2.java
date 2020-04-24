package com.ruida.springbootdemo.entity.singleton;

/**
 * @description: 饿汉模式
 * 线程安全，比较常用，但容易产生垃圾，因为一开始就初始化
 * @author: chenjy
 * @create: 2020-04-24 15:23
 */
public class Singleton2 {

    private static Singleton2 instance = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance(){
        return instance;
    }

}
