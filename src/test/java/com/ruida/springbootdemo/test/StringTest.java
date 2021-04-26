package com.ruida.springbootdemo.test;

import org.junit.Test;

import java.util.UUID;

public class StringTest {
    public static void main(String[] args) {

        System.out.println("H" + "a");
        //H 72
        //a 97
        System.out.println('H');
        System.out.println('a');
        System.out.println('H' + 'a');
        char c = 'H';
        System.out.println(Integer.valueOf(c));

        //(String)、toString、String.valueOf的区别

        //1、(String)需保证类型一致，否则抛出ClassCaseException
        Object obj = new Integer(100);
//        String str1 = (String) obj;

        //2、toString需保证非空，否则抛出NPE异常
        Object obj2 = null;
//        obj2.toString();

        //3、String.valueOf是最稳妥的方式
        Object obj3 = null;
        System.out.println(String.valueOf(obj3));//注意是null字符串

        String s1 = "china";
        String s2 = "china";
        String s3 = new String("china");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true

        long t1 = System.currentTimeMillis();
        String str = null;
        for(int i=0;i<10000;i++){
            str += UUID.randomUUID();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("字符串拼接耗时："+(t2-t1)+"ms");

        long t3 = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<10000;i++){
            sb.append(UUID.randomUUID());
        }
        long t4 = System.currentTimeMillis();
        System.out.println("StringBuffer append方法耗时："+(t4-t3)+"ms");

        /*String str = "Aa";
        byte[] bytes = str.getBytes();
        for(byte b:bytes){
            System.out.println(b);
        }

        char[] chars = str.toCharArray();
        for(char c:chars){
            System.out.println(c);
        }*/

       /* String s1 = "123";
        String s2 = "123";

        String s3 = new String("123");
        String s4 = new String("123");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s3 == s4); // false

        String str = "abc";
        char[] c = str.toCharArray();
        System.out.println(c.length);
        String s = String.valueOf(c);
        System.out.println(s);*/
    }

    @Test
    public void test1(){
        String str = "abc";
        char[] chars = str.toCharArray();
        for(char c : chars){
            System.out.println("字符:" + c + " - 数字:" + Integer.valueOf(c));
        }

        //顺便说明char和int的关系
        int x = 'a';
        System.out.println(x);

//        char ch = x; //编译异常,因为int的层级关系比char高,需要强制类型转换
        char ch = (char) x;
        System.out.println(ch);
    }

    @Test
    public void test2(){
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
        System.out.println(s3 == s4);
        s3.intern();
        s4.intern();
        System.out.println(s3 == s2);
        System.out.println(s3 == s4);
    }

    @Test
    public void test3(){
        String s0 = "ab";
        final String s1 = "b";//带final和不带final的效果不同
        String s2 = "a" + s1;
        System.out.println((s0 == s2));

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    /**
     * split同时支持多种分隔符
     */
    @Test
    public void test4(){
        // \\\\代表以\分割内容
        String origin = "1\\2\\3\\4";
        String[] arr = origin.split("[,\\.，。、\\\\]");
        for(String s : arr){
            System.out.println(s);
        }
    }

    @Test
    public void test5(){
        String str = "         分割符号的法国发过法国发过覆盖给";
        String s = str.replaceAll("\\s", "&nbsp;");
        System.out.println(s);
    }
}