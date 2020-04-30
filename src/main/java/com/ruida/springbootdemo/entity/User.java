package com.ruida.springbootdemo.entity;

import lombok.Data;

/**
 * @description: 用户
 * @author: chenjy
 * @create: 2020-04-27 15:10
 */
@Data
public class User {

    private Integer id;

    private String name;

    private Integer age;

    private String deptId;

}
