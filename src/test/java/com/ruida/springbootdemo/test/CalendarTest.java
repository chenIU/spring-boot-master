package com.ruida.springbootdemo.test;

import org.junit.Test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * BTW LocalDate、LocalTime、LocalDateTime和传统时间类相比一是操作更加简单灵活;二是线程安全。
 * @author: chenjy
 * @create: 2020-09-29 14:05
 */
public class CalendarTest {
    public static void main(String[] args) {

        //实例化
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
    }

    /*
     * 实例化特定时间
     */
    @Test
    public void instanceGivenTime(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse("2020-09-29 15:30:51");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar);
    }

    /*
     * Date和Calendar相互转换
     */
    @Test
    public void convert(){
        Date date = new Date();
        System.out.println(date);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar);

        Date date1 = calendar.getTime();
        System.out.println(date1);
    }

    /*
     * 操作时间
     */
    @Test
    public void operateTime(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        calendar.add(Calendar.MONTH,1);
        System.out.println(calendar.getTime());

        /*
         * 关于Calendar的add方法
         * abstract add(int field,int amount)
         *
         * field表示时间量,可以取如下值:
         * Calendar.ERA
         * Calendar.YEAR
         * Calendar.MONTH
         * Calendar.DATE
         * Calendar.DAY
         * Calendar.HOUR
         * Calendar.MINUTE
         * Calendar.SECOND
         *
         * amount表示在当前时间上加上对应量,如果为负数,表示在当前时间上减去对应值
         */
    }
}
