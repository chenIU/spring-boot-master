package com.ruida.springbootdemo.test;

/**
 * @description:
 * @author: chenjy
 * @create: 2021-01-04 14:07
 */
public class TestStringAPI {

    public static void main(String[] args) {
        String str1 = "aaabbbcddd";
        String str2 = "eee";

        //charAt
        System.out.println(str1.charAt(6));//c

        //startsWith
        System.out.println(str1.startsWith("aaa"));//true

        //endsWith
        System.out.println(str1.endsWith("ddd"));//true

        //concat
        System.out.println(str1.concat(str2));//aaabbbcdddeee

        //contain
        System.out.println(str1.contains("aaa"));//true

        //indexOf
        System.out.println(str1.indexOf("c"));//6

        //isEmpty
        System.out.println(str1.isEmpty());//false

        //lastIndexOf
        System.out.println(str1.lastIndexOf("b"));//5

        //length(String有length方法,数组有length属性)
        System.out.println(str1.length());//10

        //trim(去除首位的空格)
        System.out.println(" abc ".trim());

        //toUpperCase
        System.out.println("abc".toUpperCase());

        //toLowerCase
        System.out.println("ABC".toLowerCase());

        //subString
        System.out.println(str1.substring(1,3));//aa
        System.out.println(str1.substring(3));//bbbcddd

        //join
        System.out.println(String.join("-","aaa","bbb","ccc"));//aaa-bbb-ccc

        //replace,replaceAll,replaceFirst(replace和replaceAll的区别在于后者支持正则表达式)
        System.out.println(str1.replace("a","x"));
        System.out.println(str1.replaceAll("a","x"));
        System.out.println(str1.replaceFirst("a","x"));
        System.out.println("Hello Java. Java is a language.".replace("Java.","C++"));
        System.out.println("Hello Java. Java is a language.".replaceAll("Java.","C++"));

        //split
        String str3 = "aaa,bbb,ccc";
        for (String str:str3.split(",")){
            System.out.println(str);
        }

        //toCharArray
        String str4 = "中国";
        char[] chars = str4.toCharArray();
        for(char c : chars){
            System.out.println(c);
        }

        //getBytes
        byte[] bytes = str1.getBytes();
        for(byte b:bytes){
            System.out.println(b);
        }
    }
}
