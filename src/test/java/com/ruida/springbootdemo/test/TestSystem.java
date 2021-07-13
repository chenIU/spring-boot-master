package com.ruida.springbootdemo.test;


import java.nio.charset.Charset;

/**
 * @author Chen.J.Y
 * @date 2021/7/5
 */
public class TestSystem {

    public static void main(String[] args) {
        System.out.println("系统默认编码：" + System.getProperty("file.encoding"));
        System.out.println("系统默认字符编码：" + Charset.defaultCharset());
        System.out.println("系统默认语言：" + System.getProperty("user.language"));
    }
}
