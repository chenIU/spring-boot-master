package com.ruida.springbootdemo.generic;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-10 16:33
 */
public class Test {

    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.set(100);
        System.out.println(box.get());
    }

}
