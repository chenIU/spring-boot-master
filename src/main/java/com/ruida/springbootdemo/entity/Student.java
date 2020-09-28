package com.ruida.springbootdemo.entity;

import com.ruida.springbootdemo.annotation.Alpha;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 学生实体类
 * @author: chenjy
 * @create: 2020-04-01 17:25
 */
@Data
public class Student implements Serializable {

    private int id;

    @Alpha(name="jack",value = "hahaha")
    private String name = "jack";

    private transient Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


}
