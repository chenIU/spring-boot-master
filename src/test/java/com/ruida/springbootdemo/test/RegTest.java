package com.ruida.springbootdemo.test;

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
}
