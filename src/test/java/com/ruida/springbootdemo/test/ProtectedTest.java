package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.domain.Dog;

/**
 * @description: 不同包，且没有继承关系的类不能访问被protected修饰符修饰的内容
 * @author: chenjy
 * @create: 2020-12-28 10:37
 */
public class ProtectedTest {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.getAge();
        dog.getGender();
//        dog.getX();
    }
}
