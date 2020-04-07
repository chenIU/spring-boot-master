package com.ruida.springbootdemo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 正则表达式工具类
 * @author: chenjy
 * @create: 2020-04-07 08:59
 */
public class RegUtil {
    
    public static final String PHONE_PATTERN = "^1[3|5|6|7|8|9][0-9]{9}$";

    /**
     * 判断是否为手机号码
     * @param phone 手机号码
     * @return
     */
    public static boolean checkPhoneNum(String phone){
        boolean flag = false;
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        boolean b = matcher.matches();
        if(b){
            flag = true;
        }
        return  flag;
    }

    public static void main(String[] args) {
        String phone = "18848956818";
        System.out.println(checkPhoneNum(phone));
    }
}
