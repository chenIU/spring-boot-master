package com.ruida.springbootdemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 * 
 */
@Data
public class Person implements Serializable {
    private Integer id;

    private String firstName;

    private String lastName;

    private String city;

    private static final long serialVersionUID = 1L;
}