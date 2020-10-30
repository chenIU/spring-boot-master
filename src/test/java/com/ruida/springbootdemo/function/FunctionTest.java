package com.ruida.springbootdemo.function;

import java.util.function.IntToDoubleFunction;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-28 10:47
 */
public class FunctionTest {
    public static void main(String[] args) {
        IntToDoubleFunction function = (x) -> Double.valueOf(x*2);
        System.out.println(function.applyAsDouble(10));

        int[] array = {1,2,3,4,5};
        System.out.println(MyFunctionInterface.sum(array));
    }
}
