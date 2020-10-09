package com.ruida.springbootdemo.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-09 13:17
 */
@Data
public class Phone {

    private Integer userId;

    private String brand;

    private BigDecimal price;
}
