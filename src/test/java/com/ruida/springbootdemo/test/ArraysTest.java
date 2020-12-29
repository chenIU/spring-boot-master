package com.ruida.springbootdemo.test;

import java.util.Arrays;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-28 13:58
 */
public class ArraysTest {
    public static void main(String[] args) {
        String[][] arr = new String[2][2];
        arr[0][0] = "a";
        arr[0][1] = "b";
        arr[1][0] = "c";
        arr[1][1] = "d";
        System.out.println(Arrays.deepToString(arr));

        String[] ss = new String[]{"jack","mike"};
        String _t = Arrays.deepToString(ss);
        System.out.println(_t.substring(1,_t.length() - 1));

        //扩充知识点
        //Q：为什么数组打印时内容被中括号包围
        //A：查看Arrays.toString源码可得到答案
    }
}
