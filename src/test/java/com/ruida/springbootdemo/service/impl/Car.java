package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.service.Vehicle;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-11 10:54
 */
@Service
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started...");
    }
}
