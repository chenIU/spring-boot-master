package com.ruida.springbootdemo.generic;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 16:23
 */
public class GenericClassTest {
    public static void main(String[] args) {

        //string类型
        com.ruida.springbootdemo.generic.Generic<String> test1 = new com.ruida.springbootdemo.generic.Generic<>();
        test1.setKey("hello");
        System.out.println(test1.getKey());

        //Integer类型
        com.ruida.springbootdemo.generic.Generic<Integer> test2 = new com.ruida.springbootdemo.generic.Generic<>();
        test2.setKey(100);
        System.out.println(test2.getKey());
    }
}
