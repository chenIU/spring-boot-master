package com.ruida.springbootdemo.test;

import com.ruida.springbootdemo.model.ShapeFactory;
import com.ruida.springbootdemo.service.Shape;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-09 15:48
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape shape1 = factory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = factory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = factory.getShape("SQUARE");
        shape3.draw();
    }
}
