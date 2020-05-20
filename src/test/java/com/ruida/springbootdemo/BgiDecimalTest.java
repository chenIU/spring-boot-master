package com.ruida.springbootdemo;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-05-20 10:48
 */
public class BgiDecimalTest {

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal(Double.toString(0.3));
        System.out.println("a=="+a);
        System.out.println("========");
        BigDecimal b = new BigDecimal("0.1");
        System.out.println("b=="+b);
        System.out.println(new BigDecimal("0.1").divide(new BigDecimal("0.3"),2,BigDecimal.ROUND_HALF_UP));

        BigDecimal aa = new BigDecimal("-2.225000");
        int count = aa.scale();
        System.out.println(count);
        System.out.println(aa.setScale(2, BigDecimal.ROUND_DOWN));
        System.out.println(aa.setScale(2,BigDecimal.ROUND_UP));
        System.out.println(aa.setScale(2,BigDecimal.ROUND_CEILING));
        System.out.println(aa.setScale(2, BigDecimal.ROUND_FLOOR));
        System.out.println(aa.setScale(2, BigDecimal.ROUND_HALF_UP));
        System.out.println(aa.setScale(2, BigDecimal.ROUND_HALF_DOWN));

        BigDecimal enDecimal = new BigDecimal("111231.555").setScale(2, RoundingMode.HALF_UP);
        System.out.println(enDecimal.toString());


        BigDecimal start = new BigDecimal(1.55);
        System.out.println(start);

    }

}
