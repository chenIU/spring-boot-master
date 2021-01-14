package com.ruida.springbootdemo.test;

/**
 * @description: 测试tryCatchFinally
 * @author: chenjy
 * @create: 2021-01-04 09:34
 */
public class TestTryCatch {

    public static void main(String[] args) {
        try {
            throw new IllegalArgumentException("参数不合法");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("hello world");
        }

        //总结try-catch-finally中,catch和finally都可以省略,但是不能同时省略。 finally中的代码一定会执行
    }
}
