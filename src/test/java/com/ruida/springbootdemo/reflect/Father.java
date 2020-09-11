package com.ruida.springbootdemo.reflect;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 08:52
 */
public class Father {

    private String name;

    private String id;

    public String t;

    public Father() {
        System.out.println("super class constructor...");
    }

    public Father(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void eat(){
        System.out.println("super class eating...");
    }

    private void sleep(){
        System.out.println("super class sleep...");
    }

    public void sleep(long time){
        System.out.println("super class sleep  "+time+"ms");
    }
}
