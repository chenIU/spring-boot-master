package com.ruida.springbootdemo.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @description: 用户
 * @author: chenjy
 * @create: 2020-04-27 15:10
 * <p>
 * 1、JsonIgnore用户排除某个属性，作用于字段
 * 2、JsonIgnoreProperties类注解，在序列化为json时排除某些属性
 * 3、JsonIgnoreType类注解，会排除所有指定类型的属性
 * 4、JsonPropertyOrder指定序列化时属性的顺序
 * 5、JsonRootName指定json根属性的名称
 * 6、JsonProperty指定序列化为json时的属性名称
 * 7、JsonFormat指定输出的格式
 * </p>
 */
@Data
@JsonIgnoreProperties(value = "age")
@JsonIgnoreType
@JsonPropertyOrder({"name","id"})
@JsonRootName("User")
public class User implements Serializable {

    private Integer id;

    @JsonProperty("Nickname")
    private String name;

    private Integer age;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthday;

    @JsonIgnore
    private Integer deptId;

}
