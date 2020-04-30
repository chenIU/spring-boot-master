package com.ruida.springbootdemo.lambda.test;

import com.ruida.springbootdemo.lambda.NoReturnMultiParam;
import com.ruida.springbootdemo.lambda.NoReturnOneParam;
import com.ruida.springbootdemo.lambda.ReturnMultiParam;

/**
 * @description: lambda语法简化
 * @author: chenjy
 * @create: 2020-04-24 14:07
 */
public class Test2 {

    public static void main(String[] args) {
        //1.简化参数类型，可以不写参数类型，但是必须所有参数都不写
        NoReturnMultiParam noReturnMulitParam = (a, b) -> {
            System.out.println("no return multi param");
        };
        noReturnMulitParam.method(1,2);

        //2.简化参数小括号，如果只有一个参数，可以不加小括号
        NoReturnOneParam noReturnOneParam = a -> {
            System.out.println("no return one param");
        };
        noReturnOneParam.method(1);

        //3.简化方法体大括号,如果方法体只有一条语句，则可以省略方法体大括号
        NoReturnOneParam returnOneParam = a -> System.out.println("no return one param");
        returnOneParam.method(1);

        //4.如果方法体只有一条语句，并且是return语句，则可以省略大括号
        ReturnMultiParam returnMultiParam = (a,b) -> a+b;
        System.out.println("return multi param");
        returnMultiParam.method(1,2);

    }

}
