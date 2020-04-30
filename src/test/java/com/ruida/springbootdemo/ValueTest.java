package com.ruida.springbootdemo;

/**
 * @description: 值传递测试
 * <p>
 *     实参传递给形参的是值  形参和实参在内存上是两个独立的变量 对形参做任何修改不会影响实参
 * </p>
 * @author: chenjy
 * @create: 2020-04-28 10:20
 */
public class ValueTest {
    public static void main(String[] args) {
        int b = 20;
        change(b);
        System.out.println(b);//20
    }

    private static void change(int a){
        a=100;
    }
}
