package com.ruida.springbootdemo.reflect;

import com.ruida.springbootdemo.model.Cat;

/**
 * @description: 测试获取class
 * @author: chenjy
 * @create: 2021-01-04 11:41
 */
public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c1 = Class.forName("com.ruida.springbootdemo.model.Cat");
        System.out.println(c1);

        Class<Cat> c2 = Cat.class;
        System.out.println(c2);

        Cat cat = new Cat("Tom",3);
        Class<? extends Cat> c3 = cat.getClass();
        System.out.println(c3);
    }
}
