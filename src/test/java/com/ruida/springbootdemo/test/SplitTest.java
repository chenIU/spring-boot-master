package com.ruida.springbootdemo.test;

/**
 * @description: |.+*?{[($
 * @author: chenjy
 * @create: 2020-12-18 09:56
 */
public class SplitTest {
    public static void main(String[] args) {
        String str = "2019+2020";
        String[] arr = str.split("\\+");
        for(String s:arr){
            System.out.println(s);
        }
    }
}
