package com.ruida.springbootdemo.lambda.test;

import com.ruida.springbootdemo.lambda.ReturnOneParam;

/**
 * @description: lambda进阶使用
 * 有时候我们不必要重写某个匿名内部类方法，我们可以利用lambda表达式快速指向一个已经实现的方法
 * @author: chenjy
 * @create: 2020-04-24 14:22
 */
public class Test3 {

    public static void main(String[] args) {

        ReturnOneParam lambda1 = (a) -> doubleNum(a);
        System.out.println(lambda1.method(5));

        ReturnOneParam lambda2 = Test3::doubleNum;
        System.out.println(lambda2.method(10));

        Test3 t = new Test3();
        ReturnOneParam lambda3 = t::addTwo;
        System.out.println(lambda3.method(100));

    }

    public static int doubleNum(int a){
        return  a * 2;
    }

    public int addTwo(int a){
        return a+2;
    }

}
