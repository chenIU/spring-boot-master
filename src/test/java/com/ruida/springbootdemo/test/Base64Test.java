package com.ruida.springbootdemo.test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @description: 在Java8中,Base64编码已成为Java类库的标准
 * @author: chenjy
 * @create: 2020-09-30 09:00
 */
public class Base64Test {
    public static void main(String[] args) {
        try {
            //编码
            String base64EncoderString = Base64.getEncoder().encodeToString("rookie".getBytes("utf-8"));
            System.out.println("base64编码："+base64EncoderString);

            //解码
            byte[] bytes = Base64.getDecoder().decode(base64EncoderString);
            System.out.println("base64解码："+new String(bytes));

            String base64UrlEncoderString = Base64.getUrlEncoder().encodeToString("rookie".getBytes("utf-8"));
            System.out.println("base64编码(URL)："+base64UrlEncoderString);

            StringBuffer sb = new StringBuffer();

            for(int i=0;i<10;i++){
                sb.append(UUID.randomUUID());
            }
            byte[] mimeBytes = sb.toString().getBytes("utf-8");
            String mimeEncoderString = Base64.getMimeEncoder().encodeToString(mimeBytes);
            System.out.println("base64编码(MIME)："+mimeEncoderString);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
