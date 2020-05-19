package com.ruida.springbootdemo.entity;

import lombok.Data;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-05-18 15:21
 */
@Data
public class CourseExt extends Course{

    private Integer status;

    private String createDate;

    private String createTime;

}
