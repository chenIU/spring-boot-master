package com.ruida.springbootdemo.test;

import java.util.Arrays;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-29 10:27
 */
public class ArrayTest {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9,10};
        System.arraycopy(arr1,1,arr2,0,3);
        //{2,3,4,9,10}
        System.out.println(Arrays.toString(arr2));
    }
}
