package com.ruida.springbootdemo.service;

public interface ISinger<T> {

    String APP_NAME = "WECHAT";

    void sing();

    default void eat(){};

    static void swim(){
        System.out.println("swimming...");
    }

}
