package com.ruida.springbootdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import java.io.File;
import java.util.Calendar;

@Configuration
public class ImageConfig {

    @Value("${config.image.path}")
    private String imgPath;

    public String getSubPath() {
        //获取当前的年月日
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);
        String yearPath = imgPath + "/" + year;
        mkdir(yearPath);
        String monthPath = imgPath + "/" + year + "/" + month;
        mkdir(monthPath);
        String dayPath = imgPath + "/" + year + "/" + month + "/" + day;
        mkdir(dayPath);
        return "/" + year + "/" + month + "/" + day;
    }

    public void mkdir(String path) {
        //如果不存在,创建文件夹
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
    }

    public String getImgPath() {
        return imgPath;
    }
}
