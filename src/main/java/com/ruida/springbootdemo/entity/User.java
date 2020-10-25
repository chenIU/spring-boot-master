package com.ruida.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
 * 7、JsonFormat格式化输出
 * </p>
 */
@Data
@JsonIgnoreProperties(value = "age")
@JsonIgnoreType
@JsonPropertyOrder({"id","name"})
@JsonRootName("User")
@TableName(value = "t_user")
public class User implements Serializable {

    private Integer id;

    @NotEmpty(message = "用户姓名不能为空")
    @TableField(value = "user_name")
    private String username;

    private Integer age;

    //@JsonFormat(pattern = "yyyy/MM/dd")
    //@JsonIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate birthday;

    //@JsonIgnore
    private Integer deptId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    private Date createTime;

    @TableField(exist = false)
    private List<Phone> phones;
}
