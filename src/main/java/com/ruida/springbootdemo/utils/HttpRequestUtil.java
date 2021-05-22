package com.ruida.springbootdemo.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen.J.Y
 * @date 2021/5/22
 */
public class HttpRequestUtil {

    /**
     * 从request 中获取body
     * @param request
     * @return
     */
    public static Map<String,Object> getBody(ServletRequest request){
        Map<String,Object> map = new HashMap();
        try {
            BufferedReader reader = request.getReader();
            StringBuffer sb = new StringBuffer();
            String str;
            while((str=reader.readLine()) != null){
                sb.append(str);
            }
            if(sb.length() > 1){
                map = JSONObject.parseObject(sb.toString());
            }

        } catch (IOException ignore) {}

        return map;

    }
}
