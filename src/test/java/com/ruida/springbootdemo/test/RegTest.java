package com.ruida.springbootdemo.test;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @author Chen.J.Y
 * @date 2021/5/22
 */
public class RegTest {

    public static void main(String[] args) {
        System.out.println(checkImageExtension("jpg"));
        System.out.println(checkImageExtension("jpgs"));
    }

    public static boolean checkImageExtension(String suffix){
        //(?i)表示不区分大小写
        return suffix.matches("^(?i)(jpg|jpeg|png|bmp|gif|psd)");
    }

    /**
     * 校验手机号
     */
    @Test
    public void testPhone(){
        String phone = "18848956818";
        System.out.println(Pattern.matches("^[1][3,4,5,6,7,8,9][0-9]{9}", phone));
    }

    /**
     * 校验中文字符
     */
    @Test
    public void testChinese(){
        String str = "中国";
        System.out.println(Pattern.matches("^[\\u4e00-\\u9fa5]*$", str));
    }
}
