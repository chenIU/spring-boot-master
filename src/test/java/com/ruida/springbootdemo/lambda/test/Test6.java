package com.ruida.springbootdemo.lambda.test;

import java.util.function.Consumer;

/**
 * @description: 闭包问题
 * <p>
 *     这个问题我们在匿名内部类中也会存在，如果我们把注释放开会报错，告诉我 num 值是 final 不能被改变。
 *     这里我们虽然没有标识 num 类型为 final，但是在编译期间虚拟机会帮我们加上 final 修饰关键字。
 * </p>
 * @author: chenjy
 * @create: 2020-04-24 14:45
 */
public class Test6 {

    public static void main(String[] args) {
        int num = 10;
        Consumer<String> consumer = e -> System.out.println(num);
        //num = num +2;
        consumer.accept("hello");
    }

}
