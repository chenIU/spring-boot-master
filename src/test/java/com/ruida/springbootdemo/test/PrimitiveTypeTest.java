package com.ruida.springbootdemo.test;

import org.junit.Test;

/**
 * @description: 八种基本数据类型:boolean、byte、short、char、int、float、long、double
 * @author: chenjy
 * @create: 2020-12-28 11:52
 */
public class PrimitiveTypeTest {
    boolean bo;
    byte b;
    short s;
    char c;
    int i;
    float f;
    long l;
    double d;

    @Test
    public void test(){
        System.out.println("boolean默认值"+bo);
        System.out.println("byte的大小:"+ Byte.SIZE + ";默认值:"+b + ";数据范围:" + Byte.MIN_VALUE + "-" + Byte.MAX_VALUE);
        System.out.println("short的大小:"+ Short.SIZE + ";默认值:"+s + ";数据范围:" + Short.MIN_VALUE + "-" + Short.MAX_VALUE);
        System.out.println("char的大小:"+ Character.SIZE + ";默认值:"+s + ";数据范围:" + Character.MIN_VALUE + "-" + Character.MAX_VALUE);
        System.out.println("int:"+ Integer.SIZE + ";默认值:"+s + ";数据范围:" + Integer.MIN_VALUE + "-" + Integer.MAX_VALUE);
        System.out.println("float:"+ Float.SIZE + ";默认值:"+s + ";数据范围:" + Float.MIN_VALUE + "-" + Float.MAX_VALUE);
        System.out.println("long的大小:"+ Long.SIZE + ";默认值:"+s + ";数据范围:" + Long.MIN_VALUE + "-" + Long.MAX_VALUE);
        System.out.println("double的大小:"+ Double.SIZE + ";默认值:"+s + ";数据范围:" + Double.MIN_VALUE + "-" + Double.MAX_VALUE);
    }
}
