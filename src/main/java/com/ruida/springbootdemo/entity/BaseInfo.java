package com.ruida.springbootdemo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description: 基础信息
 * @author: chenjy
 * @create: 2020-12-28 10:01
 */
@Data
public class BaseInfo {
    public Date createTime;

    public Integer createBy;
}
