package com.ruida.springbootdemo.model;

import com.ruida.springbootdemo.service.Shape;
import com.ruida.springbootdemo.service.impl.Circle;
import com.ruida.springbootdemo.service.impl.Rectangle;
import com.ruida.springbootdemo.service.impl.Square;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-09 15:44
 */
public class ShapeFactory {
    public Shape getShape(String shapeType){

        if(shapeType == null){
            return null;
        }

        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }
}
