package com.ruida.springbootdemo.test;

import org.junit.Test;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-24 11:10
 */
public class DoubleTest {
    public static void main(String[] args) {
        Double d = new Double(3.4);
        System.out.println(d.intValue());
    }

    /**
     * double类型的数字相乘(不建议),乘数不能为null
     */
    @Test
    public void test(){
        Double a = 0.1;
        Double b = 0.2;
        Double c = null;
        System.out.println(a*b);
        System.out.println(a*c);
    }
}
