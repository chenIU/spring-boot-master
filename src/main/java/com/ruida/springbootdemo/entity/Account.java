package com.ruida.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "t_account")
public class Account {

    private Integer id;

    @TableField(value = "user_name")
    private String username;

    private String password;

    private String perms;

    private String roles;
}
