package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.service.Shape;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-09 15:43
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method");
    }
}
