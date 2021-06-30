package com.ruida.springbootdemo.test.alibaba;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * M：表示月份
 * m：表示分钟
 * H：24小时制
 * h：12小时制
 * @author: chenjy
 * @create: 2020-12-07 11:20
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());

        int days = LocalDate.now().lengthOfYear();
        System.out.println(days);
    }

    @Test
    public void test1() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date date = format.parse("2021.5.9");
        System.out.println(date);
    }

    @Test
    public void test2(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(format.format(new Date()));
    }

    @Test
    public void test3(){
        System.out.println(DateUtil.year(new Date()));
    }

    /**
     * 测试hutool工具类计算两个时间的差值，不区分开始时间和结束时间
     */
    @Test
    public void testTimeBetween(){
        Date startTime = new Date();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR,3);
        Date endTime = instance.getTime();
        long between = DateUtil.between(startTime, endTime, DateUnit.MINUTE);
        System.out.println(between);
    }

    public static int workDate(Date d1,Date d2)
    {
        int count = 0;
        if(d1.after(d2))
        {
            return -1;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        while(d1.before(d2) || d1.compareTo(d2) == 0)
        {
            int day = cal.get(Calendar.DAY_OF_WEEK);
            /**
             * 周六的DAY_OF_WEEK = 7
             * 周日的DAY_OF_WEEK = 1
             */
            if(day !=7 && day !=1)
            {
                count++;
            }
            cal.add(Calendar.DATE,1);
            d1 = cal.getTime();
        }
        return count;
    }

    @Test
    public void testWorkDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = df.parse("2021-06-28");
            d2 = df.parse("2021-07-11");
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(workDate(d1, d2));
    }

    @Test
    public void testDayOfWeek(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -2);
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
    }
}
