package com.ruida.springbootdemo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description: http请求工具类
 * @author: chenjy
 * @create: 2020-03-31 16:09
 */
public class HttpUtil {

    public static String sendGetRequest(String requestUrl,String requestMethod,String requestData){
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setConnectTimeout(60000);
            conn.setReadTimeout(6000);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.connect();

            // 请求内容
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(requestData);
            out.flush();
            out.close();

            // 读取返回内容
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String requestUrl = "http://localhost:8080/user/request";
        String requestMethod = "GET";
        String requestData = "中国";
        System.out.println(sendGetRequest(requestUrl,requestMethod,requestData));
    }

}
