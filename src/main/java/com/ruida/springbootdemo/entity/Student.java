package com.ruida.springbootdemo.entity;

import com.ruida.springbootdemo.annotation.Alpha;
import lombok.Data;

/**
 * @description: 学生实体类
 * @author: chenjy
 * @create: 2020-04-01 17:25
 */
@Data
public class Student {
    private int id;

    @Alpha(name="jack",value = "hahaha")
    private String name;

    private int age;
}
