package com.ruida.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 博客
 * @author: chenjy
 * @create: 2020-06-12 09:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private int id;

    private String name;

    private String url;

}
