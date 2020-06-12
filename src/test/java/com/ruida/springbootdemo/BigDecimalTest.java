package com.ruida.springbootdemo;

import java.math.BigDecimal;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-04-27 13:16
 */
public class BigDecimalTest {
    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("0.00");
        BigDecimal b = new BigDecimal("0.0");

        System.out.println(a.equals(b));

        System.out.println(a.compareTo(b)==0);

        System.out.println(BigDecimal.ZERO);

      /*  BigDecimal a = BigDecimal.ZERO;
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(a.add(b));

        Integer i = null;
        System.out.println(i.equals(0));*/

      /*  BigDecimal b1 = new BigDecimal(0.1);
        System.out.println(b1);
        BigDecimal b2 = new BigDecimal("0.1");
        System.out.println(b2);
        BigDecimal b3 = BigDecimal.valueOf(0.1);
        System.out.println(b3);
        System.out.println(0.1+0.2);
        Map<String,Object> map = new HashMap();
        map.put("name","chenjy");
        System.out.println(map.put("name","jack"));
        System.out.println(map.get("name"));
        String key = "redis_cache_%s";
        String name = "chenjy";
        boolean bool = true;
        char c = 'c';
        System.out.println(String.format(key,name));
        System.out.println(String.format(key,bool));
        System.out.println(String.format(key,c));
        System.out.printf("字母A的散列码是：%h %n", 'A');
        System.out.printf("布尔结果是：%b", "小超".equals("帅哥"));*/

    }
}
