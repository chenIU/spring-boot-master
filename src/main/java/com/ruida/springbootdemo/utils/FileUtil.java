package com.ruida.springbootdemo.utils;

import org.springframework.boot.system.ApplicationHome;

import java.io.File;

/**
 * @author Chen.J.Y
 * @date 2021/5/22
 */
public class FileUtil {

    private static String WEB_ROOT_PATH = null;

    public static final String UPLOAD_BASE_DIR = "upload";

    public static final String STATIC_DIR = "static";

    public static String getWebRootPath(){
        if(WEB_ROOT_PATH == null){
            ApplicationHome applicationHome = new ApplicationHome();
            WEB_ROOT_PATH = applicationHome.getDir().getAbsolutePath();
        }
        return WEB_ROOT_PATH;
    }

    public static String getStaticDir(){
        StringBuilder sb = new StringBuilder(getWebRootPath())
                .append(File.separator)
                .append(UPLOAD_BASE_DIR)
                .append(File.separator)
                .append(STATIC_DIR);
        return sb.toString();
    }
}
