package com.ruida.springbootdemo.function;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-28 11:05
 */
public class FunctionInterfaceWithExceptionTest {

    public static void main(String[] args) {
        FunctionInterfaceWithException target = i -> i+1;
        try {
            System.out.println(target.apply(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
