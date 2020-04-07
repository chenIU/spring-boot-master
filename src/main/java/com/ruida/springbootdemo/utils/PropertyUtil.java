package com.ruida.springbootdemo.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description: 配置文件工具类
 * @author: chenjy
 * @create: 2020-04-07 11:07
 */
public class PropertyUtil {

    private static Logger log = LoggerFactory.getLogger(PropertyUtil.class);

    private static Properties props;

    static {
        loadProps("dbconfig.properties");
    }

    synchronized static void loadProps(String file){
        props = new Properties();
        InputStream in;
        in = PropertyUtil.class.getClassLoader().getResourceAsStream(file);
        try {
            props.load(in);
        } catch (IOException e) {
            log.error("出现了IO异常...");
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                log.error("流关闭异常...");
                e.printStackTrace();
            }
        }
        log.info("property文件内容读取成功！");
        log.info("property文件内容为"+props);
    }

    public static String getKey(String key){
        if(props==null){
            loadProps("dbconfig.properties");
        }
        return props.getProperty(key);
    }

    public static void main(String[] args) {
        String dbname = PropertyUtil.getKey("dbname");
        System.out.println(dbname);
    }

}
