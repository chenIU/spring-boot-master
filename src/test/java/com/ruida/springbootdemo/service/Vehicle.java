package com.ruida.springbootdemo.service;

public interface Vehicle {

    void start();

    /*
     * 默认方法就是接口可以有自己的实现方法,而且不需要实现类去实现其方法。(java8新特性)
     */
    default void print(){
        System.out.println("我是交通工具...");
    }

    /*
     * java8另一个新特性是接口可以声明(并且可以提供实现)静态方法
     */
    static void blowHorn(){
        System.out.println("按喇叭");
    }
}
