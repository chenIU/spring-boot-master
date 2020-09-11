package com.ruida.springbootdemo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 09:54
 */
public class PropertyTest {

    private static Properties properties;

    static{
        InputStream in = PropertyTest.class.getClassLoader().getResourceAsStream("config/dbconfig.properties");
        properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(Map.Entry<Object,Object> entry:properties.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
