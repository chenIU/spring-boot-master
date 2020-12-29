package com.ruida.springbootdemo.test;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-17 16:15
 */
public class PrimitiveParamTest {

    public static void main(String[] args) {
        int i = 100;
        System.out.println("初始值:"+i);
        checkParam(i);
        System.out.println("主方法中的i:"+i);
    }

    private static void checkParam(Integer i){
        i = i + 100;
        System.out.println("checkParam方法中的i:"+i);
    }
}
