package com.ruida.springbootdemo.reflect;

import com.ruida.springbootdemo.annotation.MyAnnotation;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 08:53
 */
@MyAnnotation("son")
public class Son extends Father{

    @MyAnnotation("name")
    private String name;

    private int id;

    public String a;

    String b;

    protected String c;

    @MyAnnotation("d")
    private String d;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    private void show(){
        System.out.println("sub class showing...");
    }

    public void eat(String food){
        System.out.println("eat  "+food);
    }

    public Son(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Son() {
        super();
        System.out.println("sub class constructor...");
    }

    private Son(String name, int id, String a, String b, String c, String d) {
        this.name = name;
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}
