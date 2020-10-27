package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.service.Calc;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-27 15:43
 */
public class CalcImpl implements Calc {
    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int multi(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        return num1 / num2;
    }
}
