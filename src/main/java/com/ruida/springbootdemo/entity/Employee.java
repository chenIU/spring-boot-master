package com.ruida.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 员工实体
 * @author: chenjy
 * @create: 2020-07-22 10:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 员工姓名
     */
    private String ename;


}
