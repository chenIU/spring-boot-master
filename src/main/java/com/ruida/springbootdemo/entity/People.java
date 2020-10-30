package com.ruida.springbootdemo.entity;

import lombok.Data;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-30 11:18
 */
@Data
public class People {

    private String name;

    private int age;

    private City city;
}
