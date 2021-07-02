package com.ruida.springbootdemo.test.alibaba;

import java.util.Random;

/**
 * @description:
 * Math.random()的取值范围是[0,1)，可以取到0，至于除0异常。
 * @author: chenjy
 * @create: 2020-12-07 13:44
 */
public class RandomTest {
    public static void main(String[] args) {
        System.out.println(Math.random());
        Random random = new Random();
        System.out.println(random.nextInt());

        // random.nextInt(n)：产生一个[0,n)之间的数字
        System.out.println(random.nextInt(10));
    }
}
