package com.ruida.springbootdemo.test;

import java.util.Base64;

/**
 * @description: Base64解码jwt token
 * @author: chenjy
 * @create: 2020-09-30 09:00
 */
public class Base64Test2 {
    public static void main(String[] args) {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDQyOTQ0NzUsInVzZXJJZCI6IjEiLCJ1c2VybmFtZSI6InpzIn0.U7bbmbSBogIXw9LeZjDO1oe1_rD8UIN1vIg5Gs9d_EU";
        String header = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9";
        String payload = "eyJleHAiOjE2MDQyOTQ0NzUsInVzZXJJZCI6IjEiLCJ1c2VybmFtZSI6InpzIn0";
        String signature = "U7bbmbSBogIXw9LeZjDO1oe1_rD8UIN1vIg5Gs9d_EU";

        //解码header
        System.out.println(new String(Base64.getDecoder().decode(header)));

        //解码payload
        System.out.println(new String(Base64.getDecoder().decode(payload)));
    }
}
