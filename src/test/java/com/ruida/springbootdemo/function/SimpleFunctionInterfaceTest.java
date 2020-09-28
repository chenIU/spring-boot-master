package com.ruida.springbootdemo.function;

/**
 * @description: 说明不必用@FunctionInterface显示声明一个接口是函数式接口
 * @author: chenjy
 * @create: 2020-09-28 11:26
 */
public class SimpleFunctionInterfaceTest {

    public static void main(String[] args) {
        SimpleFunctionInterface functionInterface = i -> i;
        System.out.println(functionInterface.accept(10));
    }
}
