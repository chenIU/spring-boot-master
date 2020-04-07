package com.ruida.springbootdemo.utils;

import java.util.Arrays;

/**
 * @description: 数组工具类
 * @author: chenjy
 * @create: 2020-04-07 09:52
 */
public class ArrayUtil {

    public static int[] a = {1,2,3};

    public static int[][] b = {{1,2,3},{4,5,6}};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.deepToString(b));
    }
}
