package com.ruida.springbootdemo.entity;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 * 
 */
@Data
public class Person implements Serializable {
    private Integer id;

    private MysqlxDatatypes.Scalar.String firstName;

    private String lastName;

    private String city;

    private static final long serialVersionUID = 1L;
}