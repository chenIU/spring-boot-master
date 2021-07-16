package com.ruida.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.*;
import com.ruida.springbootdemo.annotation.DesensitizeAnnotation;
import com.ruida.springbootdemo.annotation.InEnum;
import com.ruida.springbootdemo.core.groups.Update;
import com.ruida.springbootdemo.enums.DesensitizationStrategy;
import com.ruida.springbootdemo.enums.GenderEnum;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @description: 用户
 * @author: chenjy
 * @create: 2020-04-27 15:10
 * {@link GenderEnum}
 * @see com.ruida.springbootdemo.enums.GenderEnum
 * <p>
 * 1、JsonIgnore用户排除某个属性，作用于字段
 * 2、JsonIgnoreProperties类注解，在序列化为json时排除某些属性
 * 3、JsonIgnoreType类注解，当其他类引用该类时，该属性被忽略
 * 4、JsonPropertyOrder指定序列化时属性的顺序
 * 5、JsonRootName指定json根属性的名称
 * 6、JsonProperty指定序列化为json时的属性名称
 * 7、JsonFormat格式化输出
 * </p>
 */
@Data
@NoArgsConstructor
//@JsonIgnoreProperties(value = "age")
@JsonIgnoreType
@JsonPropertyOrder({"id","name"})
@JsonRootName("User")
@TableName(value = "t_user")
@Getter
public class User implements Serializable {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    @NotEmpty(message = "用户姓名不能为空")
    @TableField(value = "user_name")
    @DesensitizeAnnotation(strategy = DesensitizationStrategy.USERNAME)
    private String username;

    private String password;

    private Integer age;

    @InEnum(value = GenderEnum.class,message = "性别必须是{value}")
    private Integer gender;

    //@JsonFormat(pattern = "yyyy/MM/dd")
    //@JsonIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDate birthday;

    //@JsonIgnore
    private Integer deptId;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
    //将时间转换成时间戳的形式
    //@JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date createTime;

    @TableField(exist = false)
    private List<Phone> phones;

    public User(@NotEmpty(message = "用户姓名不能为空") String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
