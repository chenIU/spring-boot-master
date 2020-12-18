package com.ruida.springbootdemo.utils;

import java.util.regex.Pattern;

/**
 * @description: string工具类
 * @author: chenjy
 * @create: 2020-04-01 14:49
 */
public class StringUtil {

    private static final String NUMERIC_PATTERN = "[0-9]*";
    private static final String EMAIL_PATTERN = "\\w+@(\\w+.)+[a-z]{2,3}";
    private static final String PHONE_PATTERN = "^1[3|5|6|7|8|9|][0-9]{9}$";
    private static final String NUMERIC_PREFIX_PATTERN  = "^[0-9].*";

    public static final String REDIS_KEY = "error_key_%s_%s";

    public static final String name = "chenjianyin";

    public static final String school = "lit";

    public static void main(String[] args) {

        String str = "chenjy.txt";
        //substring(int beginIndex)：从beginIndex一直到结尾
        System.out.println(str.substring(3));//njy.txt

        //substring(int beginIndex,int endIndex)：beginIndex(包含)到endIndex(不包含)  下标从0开始
        System.out.println(str.substring(1,3));//he

        System.out.println(str.lastIndexOf("."));//6
        System.out.println(str.substring(str.lastIndexOf(".") + 1));//txt

        char c = 'A';
        System.out.println(Integer.valueOf(c));


       /* String str = "hello";
        System.out.println(StringUtil.isBeginWithNumeric(str));*/

       /* String phone = "15225336606";
        System.out.println(StringUtil.isPhone(phone));*/

       /* String mail = "1414680900@qq.com";
        System.out.println(StringUtil.isMail(mail));*/

        /*String str = "110";
        System.out.println(StringUtil.isNumeric(str));*/

       /* System.out.println(String.format(REDIS_KEY, "iOS","bill"));

        *//**
         * 利用google guava快速对字符串进行格式化输出
         *//*
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
        System.out.println(Arrays.deepToString(b));*/

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

    /**
     * 判断输入是否为数字
     * @param input
     * @return
     */
    public static boolean isNumeric(String input){
        return Pattern.compile(NUMERIC_PATTERN).matcher(input).matches();
    }

    /**
     * 判断输入是否为邮箱
     * @param mail
     * @return
     */
    public static boolean isMail(String mail){
        return Pattern.compile(EMAIL_PATTERN).matcher(mail).matches();
    }

    /**
     * 判断是否为手机号
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone){
        return Pattern.compile(PHONE_PATTERN).matcher(phone).matches();
    }

    /**
     * 判断是否以数字开头
     * @param input
     * @return
     */
    public static boolean isBeginWithNumeric(String input){
        return Pattern.compile(NUMERIC_PREFIX_PATTERN).matcher(input).matches();
    }

}
