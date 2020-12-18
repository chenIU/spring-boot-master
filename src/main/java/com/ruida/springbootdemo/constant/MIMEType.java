package com.ruida.springbootdemo.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-18 14:47
 */
public class MIMEType {

    public static final Map<String,String> types = new HashMap<String,String>(){{
        put("image/gif",".gif");
        put("image/jpeg",".jpg");
        put("image/jpg",".jpg");
        put("image/png",".png");
        put("image/bmp",".bmp");
    }};

    public static String getSuffix(String mimeType){
        return types.get(mimeType);
    }
}
