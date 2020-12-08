package com.ruida.springbootdemo.test.job;

/**
 * @description: 整数符号位问题
 * @author: chenjy
 * @create: 2020-11-25 14:25
 */
public class Test5 {

    public static final Integer END_NUMBER = Integer.MAX_VALUE;

    public static final Integer START_NUMBER = END_NUMBER - 2;

    public static void main(String[] args) {
        int count = 0;
        System.out.println(END_NUMBER);
        for (int i = START_NUMBER; i <= END_NUMBER; i++) count++;
        System.out.println(count);
    }
}
