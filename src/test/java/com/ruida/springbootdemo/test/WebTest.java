package com.ruida.springbootdemo.test;

import org.springframework.boot.system.ApplicationHome;

/**
 * @author Chen.J.Y
 * @date 2021/5/22
 */
public class WebTest {

    private static String WEB_ROOT = null;

    public static String getWebRoot(){
        if(WEB_ROOT == null){
            ApplicationHome applicationHome = new ApplicationHome();
            WEB_ROOT = applicationHome.getDir().getAbsolutePath();
        }
        return WEB_ROOT;
    }

    public static void main(String[] args) {
        System.out.println(getWebRoot());
    }
}
