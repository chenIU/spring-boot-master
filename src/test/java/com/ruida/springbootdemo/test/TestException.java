package com.ruida.springbootdemo.test;

/**
 * @description: 异常测试类
 * @author: chenjy
 * @create: 2020-04-29 16:42
 */
public class TestException {

    public static void main(String[] args) {

        System.out.println(divide(0.1,0));

    }

    public static double divide(double a,double b){
        if(b==0){
            throw new RuntimeException("被除数不能为0");
        }
        return a/b;
    }

}
