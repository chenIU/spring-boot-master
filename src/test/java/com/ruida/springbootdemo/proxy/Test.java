package com.ruida.springbootdemo.proxy;

import com.ruida.springbootdemo.service.Calc;
import com.ruida.springbootdemo.service.impl.CalcImpl;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-10-27 15:45
 */
public class Test {

    public static void main(String[] args) {
        Calc  calc = new CalcImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        Calc calc1 = (Calc) myInvocationHandler.bind(calc);
        calc1.add(1,2);
        calc1.sub(2,1);
        calc1.multi(2,3);
        calc1.divide(4,2);
    }
}
