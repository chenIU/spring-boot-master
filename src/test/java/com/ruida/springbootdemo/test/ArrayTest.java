package com.ruida.springbootdemo.test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-29 10:27
 */
public class ArrayTest {

    public static void main(String[] args) {

        String[] arr = {"chen","liu","zeng"};
        System.out.println(arr);
        Stream.of(arr).forEach(System.out::println);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9,10};
        System.arraycopy(arr1,1,arr2,0,3);
        //{2,3,4,9,10}
        System.out.println(Arrays.toString(arr2));

        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(a));

        //deepToString打印二维数组;toString打印以为数组,打印二维数组的地址
        int[][] b = {{1,2,3,4},{5,6,7,8}};
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.deepToString(b));
    }
}
