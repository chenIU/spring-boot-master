package com.ruida.springbootdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 用户
 * @author: chenjy
 * @create: 2020-04-27 15:10
 */
@Data
@JsonIgnoreProperties(value = "age")
public class User implements Serializable {

    private Integer id;

    private String name;

    private Integer age;

    private Integer deptId;

}
