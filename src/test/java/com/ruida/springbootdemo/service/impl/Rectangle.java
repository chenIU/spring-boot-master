package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.service.Shape;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-09 15:42
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangel::draw() method");
    }
}
