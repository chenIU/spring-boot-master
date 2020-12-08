package com.ruida.springbootdemo.test.job;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-25 13:57
 */
public class Test1 {
    public static void main(String[] args) {
        Integer total = 0;
        check(total);
        System.out.println(total);
    }

    private static void check(Integer num){
        if(num < 1){
            num += 1;
        }
    }
}
