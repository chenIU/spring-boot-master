package com.ruida.springbootdemo.domain;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 14:50
 */
public class Father {

    protected int id;

    protected String b;

    String c;

    public String d;

    public void eat(){
        System.out.println("father eating...");
    }

    public Father(){
        System.out.println("father's none parameter constructor");
    }

    public Father(int id){
        this.id = id;
        System.out.println("father's has id property constructor");
    }
}
