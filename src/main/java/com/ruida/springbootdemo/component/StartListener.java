package com.ruida.springbootdemo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @description: 启动监听
 * @author: chenjy
 * @create: 2020-12-16 15:11
 */
@Component
@Slf4j
public class StartListener implements ApplicationListener<ApplicationReadyEvent> {
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        log.error("项目启动监听...");
    }
}
