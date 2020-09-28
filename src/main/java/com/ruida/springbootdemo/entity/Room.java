package com.ruida.springbootdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-28 16:30
 */
@Data
@AllArgsConstructor
public class Room {

    private String length;

    private double width;

    private double height;
}
