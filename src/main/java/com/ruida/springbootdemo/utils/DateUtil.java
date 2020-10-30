package com.ruida.springbootdemo.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-24 13:22
 */
public class DateUtil {

    public static void main(String[] args) {
        Date date = new Date();
        date.setMinutes(58);
        System.out.println(checkIfCanTest(date));

      /*  Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());

        c.add(Calendar.MINUTE, 5);
        System.out.println(c.getTime());*/

       /* Date startTime = new Date();
        startTime.setDate(26);

        Date endTime = new Date();
        endTime.setDate(30);
        System.out.println(startTime);
        System.out.println(endTime);
        System.out.println(checkTime(startTime,endTime));*/
    }

    public static boolean checkTime(Date startTime,Date endTime){
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());

        Calendar start = Calendar.getInstance();
        start.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if(now.after(start) && now.before(end)){
            return true;
        }else {
            return false;
        }
    }

    private static boolean checkIfCanTest(Date testStartTime){
        Calendar startTime = Calendar.getInstance();
        startTime.setTime(testStartTime);

        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(new Date());

        Calendar fiveMinutesLater = startTime;
        fiveMinutesLater.add(Calendar.MINUTE,5);

        System.out.println(startTime.before(nowTime));

        if(startTime.before(nowTime) || fiveMinutesLater.after(nowTime)){
            return true;
        }
        return false;
    }
}
