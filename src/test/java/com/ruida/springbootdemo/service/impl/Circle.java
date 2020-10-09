package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.service.Shape;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-09 15:41
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method");
    }
}
