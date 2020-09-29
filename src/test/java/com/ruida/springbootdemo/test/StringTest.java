package com.ruida.springbootdemo.test;

public class StringTest {
    public static void main(String[] args) {

        String str = "Aa";
        byte[] bytes = str.getBytes();
        for(byte b:bytes){
            System.out.println(b);
        }

        char[] chars = str.toCharArray();
        for(char c:chars){
            System.out.println(c);
        }

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
}
