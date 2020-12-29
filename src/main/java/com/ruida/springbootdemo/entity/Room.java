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
public class Room implements Comparable<Room>{

    private String length;

    private Double width;

    private Double height;

    @Override
    public int compareTo(Room o) {
        return height.compareTo(o.height);
    }
}
