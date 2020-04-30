package com.ruida.springbootdemo.utils;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: string工具类
 * @author: chenjy
 * @create: 2020-04-01 14:49
 */
public class StringUtil {

    public static final String REDIS_KEY = "error_key_%s_%s";

    public static final String name = "chenjianyin";

    public static final String school = "lit";

    public static void main(String[] args) {

        System.out.println(String.format(REDIS_KEY, "iOS","bill"));

        /**
         * 利用google guava快速对字符串进行格式化输出
         */
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(Joiner.on(",").join(list));

        System.out.println(getSuffix("Snipaste_2020-03-26_13-48-25.png"));

        int a[] = {1, 2, 3};
        System.out.println(Arrays.toString(a));
        int b[][] = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.deepToString(b));

    }

    /**
     * 获取文件的后缀名
     * @param name 文件名称
     * @return
     */
    public static String getSuffix(String name){
        int index = name.lastIndexOf('.');
        String suffix = name.substring(index+1);
        return suffix;
    }

}
