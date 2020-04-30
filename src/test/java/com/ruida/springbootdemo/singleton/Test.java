package com.ruida.springbootdemo.singleton;

/**
 * @description: 单例模式测试类
 * @author: chenjy
 * @create: 2020-04-24 15:21
 */
public class Test {

    public static void main(String[] args) {

        //singleton1
        Singleton5 s1 = Singleton5.getInstance();
        Singleton5 s2 = Singleton5.getInstance();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1==s2);

    }

}
