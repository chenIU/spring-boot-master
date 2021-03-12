package com.ruida.springbootdemo.component;

import com.ruida.springbootdemo.config.DBConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import javax.annotation.Resource;

/**
 * @description: 启动监听
 * @author: chenjy
 * @create: 2020-12-16 15:11
 */
@Slf4j
//@Component
public class StartListener implements ApplicationListener<ApplicationReadyEvent> {

    @Resource
    private DBConfig dbConfig;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.error("项目启动监听...");
        for(Object key: DBConfig.properties.keySet()){
            log.info("{}={}",key, DBConfig.properties.getProperty((String) key));
        }
    }
}
