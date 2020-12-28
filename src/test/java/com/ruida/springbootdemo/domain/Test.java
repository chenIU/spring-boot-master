package com.ruida.springbootdemo.domain;

/**
 * @description: 同包中可以访问protected修饰符修饰的内容
 * @author: chenjy
 * @create: 2020-12-28 10:35
 */
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.getAge();
        dog.getGender();
        dog.getX();
    }
}
