package com.ruida.springbootdemo.entity.singleton;

/**
 * @description: 静态内部类
 * 是目前最推荐的创建单例的方式
 * @author: chenjy
 * @create: 2020-04-24 15:32
 */
public class Singleton4 {

    private Singleton4(){}

    public static Singleton4 getInstance(){
        return Inner.instance;
    }

    private static class Inner{
        private static final Singleton4 instance = new Singleton4();
    }

}
