package com.ruida.springbootdemo.controller;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import com.ruida.springbootdemo.transaction.SpringTx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-05-22 13:34
 */
@RestController
@RequestMapping("/hello/")
public class HelloController {

    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @Resource
    SpringTx tx;

    public static void main(String[] args) {
        log.debug("this is debug log");
        log.info("this is info log");
        log.warn("this is warn log");
        log.error("this is error log");

        //打印内部状态
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }

    @RequestMapping("tx")
    public void tx(){
        tx.transaction();
    }

}
