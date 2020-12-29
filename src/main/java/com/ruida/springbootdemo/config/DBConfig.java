package com.ruida.springbootdemo.config;

import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-18 14:58
 */
@Configuration
public class DBConfig {

    public static Properties properties = new Properties();

    static {
        properties.setProperty("username","root");
        properties.setProperty("password","123456");
        properties.setProperty("url","jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=GMT+8");
    }
}
