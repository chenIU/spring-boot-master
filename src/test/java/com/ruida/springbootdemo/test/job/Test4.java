package com.ruida.springbootdemo.test.job;

/**
 * @description: -128--127范围内赋值，在IntegerCache.cache中产生，会复用已有对象。超过此范围，则不会服用已有对象。
 * @author: chenjy
 * @create: 2020-11-25 14:12
 */
public class Test4 {
    public static void main(String[] args) {
        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);
    }
}
