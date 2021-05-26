package com.ruida.springbootdemo.utils;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @description: 时间工具类
 * @author: chenjy
 * @create: 2020-04-01 17:35
 */
public class TimeUtil {

    public static String getDateFormat(Date date){
        Instant nowInstant = new Date().toInstant();
        Instant instant = date.toInstant();
        Duration duration = Duration.between(instant, nowInstant);
        long days = duration.toDays();
        if(days < 1){
            long minutes = duration.toMinutes();
            if(minutes < 5){
                return "刚刚";
            } else {
                long hours = duration.toHours();
                if(hours < 1){
                    return minutes + "分钟前";
                } else {
                    return hours + "小时前";
                }
            }
        } else if(days < 7){
            return days + "天前";
        } else {
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            if(days < 365) {
                return DateTimeFormatter.ofPattern("MM-dd hh:mm").format(localDateTime);
            }else {
                return DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm").format(localDateTime);
            }
        }
    }
}
