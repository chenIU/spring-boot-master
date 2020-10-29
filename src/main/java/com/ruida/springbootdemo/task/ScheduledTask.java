package com.ruida.springbootdemo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-21 13:20
 */
//@Component
@Slf4j
public class ScheduledTask {

    @Scheduled(initialDelay = 10000,fixedRate = 60000)
    public void scheduledTask(){
        log.info("定时任务执行时间：{}", LocalDateTime.now());
    }

}
