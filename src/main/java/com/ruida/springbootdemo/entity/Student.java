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
    private String name;

    private transient Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
