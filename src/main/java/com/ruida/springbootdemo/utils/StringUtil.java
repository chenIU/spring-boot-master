package com.ruida.springbootdemo.utils;

import com.google.common.base.Joiner;
import java.util.ArrayList;
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
