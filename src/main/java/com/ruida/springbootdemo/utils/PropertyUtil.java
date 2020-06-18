package com.ruida.springbootdemo.utils;

import lombok.extern.slf4j.Slf4j;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description: 配置文件读取工具类
 * @author: chenjy
 * @create: 2020-06-12 11:21
 */
@Slf4j
public class PropertyUtil {

    private static Properties props;

    static {
        loadProps("config/dbconfig.properties");
    }

    synchronized static private void loadProps(String fileName) {
        log.info("开始加载dbconfig.properties配置文件内容");
        props = new Properties();
        InputStream in = null;
        try {
            in = PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
            props.load(in);
        } catch (FileNotFoundException e) {
            log.error("dbconfig.properties配置文件未找到");
        } catch (IOException e) {
            log.error("出现IOException");
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                log.error("dbconfig.properties文件流关闭异常");
            }
        }
        log.info("加载dbconfig.properties配置文件完成");
        log.info("properties配置文件内容：" + props);
    }

    public static String getProperty(String key){
        if(null == props){
            loadProps("dbconfig.properties");
        }
        return props.getProperty(key);
    }

}
