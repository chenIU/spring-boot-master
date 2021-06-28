package com.ruida.springbootdemo.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Chen.J.Y
 * @date 2021/6/27
 * 脱敏工具类
 */
public class DesensitizationUtil {

    /**
     * 只显示左侧指定长度的字符，其他以*代替
     */
    public static String left(String str, int length){
        if(StringUtils.isBlank(str))
            return "";

        if(str.length() <= length)
            return str;

        return StringUtils.rightPad(StringUtils.left(str, length), str.length(), "*");
    }

    /**
     * 只显示右侧指定长度的字符，其他以*代替
     */
    public static String right(String str, int length){
        if(StringUtils.isBlank(str))
            return "";

        if(str.length() <= length)
            return str;

        return StringUtils.leftPad(StringUtils.left(str, length), str.length(), "*");
    }

    /**
     * 保留左侧N位 右侧M位 中间以*代替
     */
    public static String around(String str, int leftLen, int rightLen){
        if(StringUtils.isBlank(str))
            return "";

        if(str.length() <= leftLen + rightLen)
            return str;

        return StringUtils.left(str, leftLen) + StringUtils.repeat("*", str.length() - leftLen - rightLen) + StringUtils.right(str, rightLen);
    }
}
