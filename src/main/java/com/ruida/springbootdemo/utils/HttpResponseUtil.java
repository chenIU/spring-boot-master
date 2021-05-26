package com.ruida.springbootdemo.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Chen.J.Y
 * @date 2021/5/26
 */
@Slf4j
public class HttpResponseUtil {

    public static void sendJsonMsg(ServletResponse response, String jsonMsg) {
        if (response == null) {
            return;
        }
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        try {
            httpResponse.reset();
        } catch (Exception e) {
            log.warn("HttpResponse 已经关闭，无法再次打开");
        }

        //禁用浏览器缓存
        httpResponse.setHeader("Cache-Control", "no-store");
        httpResponse.setDateHeader("Expires", 0);
        httpResponse.setStatus(HttpStatus.OK.value());

        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setCharacterEncoding("UTF-8");

        try {
            PrintWriter writer = httpResponse.getWriter();
            writer.write(jsonMsg);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void sendJsonMsg(ServletResponse response, Object msg) {
        if (response == null) {
            return;
        }

        String jsonMsg = "";
        if (msg != null) {
            jsonMsg = JSONObject.toJSONString(msg);
        }
        sendJsonMsg(response, jsonMsg);
    }
}
