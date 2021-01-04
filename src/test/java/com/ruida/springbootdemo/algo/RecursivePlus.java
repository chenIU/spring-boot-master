package com.ruida.springbootdemo.algo;

/**
 * @description: 递归加法
 * @author: chenjy
 * @create: 2021-01-04 11:19
 */
public class RecursivePlus {

    /**
     * 递归求和
     * @param i
     * @return
     */
    public static int sum(int i){
        if(i == 1){
            return 1;
        }
        return i + sum(i -1);
    }


    /**
     * 斐波那契数列
     * @param x
     * @return
     */
    public static int fibonacci(int x){
        if(x == 1 || x == 2){
            return 1;
        }
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    public static void main(String[] args) {
        System.out.println(sum(100));

        for (int i = 1; i < 20; i++) {
            System.out.println("兔子在第" + i + "个月的数量为:" + fibonacci(i));
        }
    }
}
