package com.ruida.springbootdemo.domain;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-28 10:34
 */
public class Dog extends Mammal{

    public void eatAndSleep(){
        super.eat();//super继承最近的父类或者接口
        System.out.println("Dog sleep...");
    }
}
