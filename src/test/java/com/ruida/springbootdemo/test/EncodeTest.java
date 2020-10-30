package com.ruida.springbootdemo.test;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-09 09:11
 */
public class EncodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "你好";
        byte[] bytes = str.getBytes("gbk");
        String utf8Str = new String(bytes,"utf-8");
        System.out.println(utf8Str);

        String gbkStr = new String(bytes,"gbk");
        System.out.println(gbkStr);
    }
}
