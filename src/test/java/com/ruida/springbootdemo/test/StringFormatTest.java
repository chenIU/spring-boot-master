package com.ruida.springbootdemo.test;

import org.junit.Test;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-30 09:01
 */
public class StringFormatTest {

    @Test
    public void test(){
        String s1 = "Hi_%s";
        System.out.println(String.format(s1,"jack"));

        String s2 = "Hi_%c";
        System.out.println(String.format(s2,'c'));

        //o(八进制) d(十进制) x(十六进制)
        String s3 = "Hi_%d";
        System.out.println(String.format(s3,100));

        String s4 = "Hi_%b";
        System.out.println(String.format(s4,false));

        String s5 = "Hi_%f";
        System.out.println(String.format(s5,1.0f));
    }
}
