package com.ruida.springbootdemo.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chenjy
 * @since 2021/2/1 10:24
 */
public class TestRoundingMode {

    public static void main(String[] args) {

        BigDecimal o1 = new BigDecimal("3.33333333333333");
        BigDecimal o2 = new BigDecimal("1.976744186046512");
        BigDecimal o3 = new BigDecimal("-4.868913857677903");
        BigDecimal o4 = new BigDecimal("-2.307692307692308");

        /**
         * 0.RoundingMode.DOWN
         * 等价枚举：BigDecimal.ROUND_DOWN
         * 舍位原则：粗暴的截断舍弃位，不考虑任何舍位操作
         * 例：scale = 2
         */
        System.out.println(o1.setScale(2, RoundingMode.DOWN));
        System.out.println(o2.setScale(2, RoundingMode.DOWN));
        System.out.println(o3.setScale(2, RoundingMode.DOWN));
        System.out.println(o4.setScale(2, RoundingMode.DOWN));
        System.out.println("==========================================");

        /**
         * 1.RoundingMode.UP
         * 等价枚举：BigDecimal.ROUND_UP
         * 舍位原则：精度保留的最后一位，朝远离数轴的方向进行。正数+1，负数-1
         * 例：scale = 2
         */
        System.out.println(o1.setScale(2, RoundingMode.UP));//3.34
        System.out.println(o2.setScale(2, RoundingMode.UP));//1.98
        System.out.println(o3.setScale(2, RoundingMode.UP));//-4.87
        System.out.println(o4.setScale(2, RoundingMode.UP));//-2.31
        System.out.println("==========================================");

        /**
         * 2.RoundingMode.CEILING
         * 等价枚举：BigDecimal.ROUND_CEILING
         * 舍位原则：精度保留的最后一位，朝数轴正方向round，正数时等价于UP，负数时等价与DOWN
         * 例：scale = 2
         */
        System.out.println(o1.setScale(2, RoundingMode.CEILING));//3.34
        System.out.println(o2.setScale(2, RoundingMode.CEILING));//1.98
        System.out.println(o3.setScale(2, RoundingMode.CEILING));//-4.86
        System.out.println(o4.setScale(2, RoundingMode.CEILING));//-2.30
        System.out.println("==========================================");

        /**
         * 3.RoundingMode.FLOOR
         * 等价枚举：BigDecimal.ROUND_FLOOR
         * 舍位原则：与CEILING相反，精度保留的最后一位，朝数轴负方向round，正数时等价于DOWN，负数时等价与UP
         * 例：scale = 2
         */
        System.out.println(o1.setScale(2, RoundingMode.FLOOR));//3.33
        System.out.println(o2.setScale(2, RoundingMode.FLOOR));//1.97
        System.out.println(o3.setScale(2, RoundingMode.FLOOR));//-4.87
        System.out.println(o4.setScale(2, RoundingMode.FLOOR));//-2.31
        System.out.println("==========================================");

        /**
         * 4.RoundingMode.HALF_UP
         * 等价枚举：BigDecimal.HALF_UP
         * 舍位原则：四舍五入
         * 例：scale = 2
         */
        System.out.println(o1.setScale(2, RoundingMode.HALF_UP));//3.33
        System.out.println(o2.setScale(2, RoundingMode.HALF_UP));//1.98
        System.out.println(o3.setScale(2, RoundingMode.HALF_UP));//-4.87
        System.out.println(o4.setScale(2, RoundingMode.HALF_UP));//-2.31
        System.out.println("==========================================");

        /**
         * 5.RoundingMode.HALF_DOWN
         * 等价枚举：BigDecimal.HALF_DOWN
         * 舍位原则：五舍六入
         * 例：scale = 2
         */
        System.out.println(o1.setScale(2, RoundingMode.HALF_DOWN));//3.33
        System.out.println(o2.setScale(2, RoundingMode.HALF_DOWN));//1.98
        System.out.println(o3.setScale(2, RoundingMode.HALF_DOWN));//-4.87
        System.out.println(o4.setScale(2, RoundingMode.HALF_DOWN));//-2.31
        System.out.println("==========================================");
    }
}
