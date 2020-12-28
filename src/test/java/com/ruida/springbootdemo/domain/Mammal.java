package com.ruida.springbootdemo.domain;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-12-28 10:33
 */
public class Mammal {

    private Integer age;

    private String gender;

    protected Object x;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    protected Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = x;
    }
}
