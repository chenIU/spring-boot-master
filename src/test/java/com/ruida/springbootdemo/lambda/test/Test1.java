package com.ruida.springbootdemo.lambda.test;

import com.ruida.springbootdemo.lambda.*;

/**
 * @description: lambda基础语法
 * ()->{} ()参数 {}方法体 -> lambda语法，读作goes to
 * @author: chenjy
 * @create: 2020-04-24 13:54
 */
public class Test1 {

    public static void main(String[] args) {

        //无参无返回
        NoReturnNoParam noReturnNoParam = ()-> {
            System.out.println("no return no param");
        };
        noReturnNoParam.method();

        //一个参数无返回
        NoReturnOneParam noReturnOneParam = (int a) -> {
            System.out.println("no return one param"+":==="+a);
        };
        noReturnOneParam.method(5);

        //多个参数无返回
        NoReturnMultiParam noReturnMultiParam = (int a,int b) -> {
            System.out.println("no return multi param"+":==="+a+":==="+b);
        };
        noReturnMultiParam.method(1,2);

        //无参数有返回
        ReturnNoParam returnNoParam = () ->{
            System.out.println("return no param");
            return 1;
        };
        returnNoParam.method();

        //一个参数有返回
        ReturnOneParam returnOneParam = (int a) -> {
            System.out.println("return no param"+":==="+a);
            return a;
        };
        returnOneParam.method(5);

        //多个参数有返回
        ReturnMultiParam returnMultiParam = (int a,int b) -> {
            System.out.println("return multi param"+":==="+a+":==="+b);
            return a+b;
        };
        returnMultiParam.method(1,2);
    }

}
