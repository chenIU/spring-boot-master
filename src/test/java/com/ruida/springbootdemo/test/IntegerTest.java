package com.ruida.springbootdemo.test;

/**
 * @description: Integer体现了设计模式总的享元模式(flyweight)
 * @author: chenjy
 * @create: 2020-09-29 08:51
 */
public class IntegerTest {

    public static void main(String[] args) {

        //valueOf：自动装箱
        Integer integer = Integer.valueOf(100);

        //intValue：自动拆箱
        int i5 = integer.intValue();

        System.out.println(1000000);

        System.out.println(1_000_000);//jdk1.7新特性,数值可加下划线

        System.out.println(0b00001_0001);//jdk1.7新特性,支持二进制数字

        //Integer最大值
        System.out.println(Integer.MAX_VALUE);//0x7fffffff 说明Integer最高位为0代表正数

        Integer a = 30;
        Integer b = 10;
        System.out.println(a.compareTo(b));// 1:大于 -1:小于 0:相等

        Integer i = 16;
        System.out.println(Integer.toHexString(i));

        //Integer类缓存了[-128,127]之间的整数
        Integer i1 = -128;
        Integer i2 = -128;
        System.out.println(i1 == i2);

        //值相同的Integer和int比较,值都为true(无论是否使用new)。因为会把Integer自动拆箱为int再去比。
        Integer i3 = 1000;
        int i4 = 1000;
        System.out.println(i3 == i4);
    }
}
