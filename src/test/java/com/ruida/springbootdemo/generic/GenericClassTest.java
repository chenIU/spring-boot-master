package com.ruida.springbootdemo.generic;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-30 16:23
 */
public class GenericClassTest {
    public static void main(String[] args) {

        //string类型
        GenericClass<String> test1 = new GenericClass<>();
        test1.setT("hello");
        System.out.println(test1.getT());

        //Integer类型
        GenericClass<Integer> test2 = new GenericClass<>();
        test2.setT(100);
        System.out.println(test2.getT());
    }
}
