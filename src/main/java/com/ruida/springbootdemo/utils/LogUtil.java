package com.ruida.springbootdemo.utils;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-06-12 10:54
 */
public class LogUtil {

    private static Logger log = LoggerFactory.getLogger(LogUtil.class);

    public static void main(String[] args) {
        log.debug("this is debug log");
        log.info("this is info log");
        log.warn("this is warn log");
        log.error("this is error log");

        //打印内部状态
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
