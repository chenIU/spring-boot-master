package com.ruida.springbootdemo.clone;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-11-26 11:15
 */
@Data
public class Major implements Cloneable, Serializable {

    private String majorName;

    private int majorId;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
