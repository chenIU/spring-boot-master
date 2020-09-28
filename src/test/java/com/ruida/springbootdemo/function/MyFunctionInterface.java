package com.ruida.springbootdemo.function;

import java.util.Arrays;

@FunctionalInterface
public interface MyFunctionInterface {
    void accept();

    String toString();

    int hashCode();

    boolean equals(Object obj);

    default void eat(){
        System.out.println("eating...");
    }

    static void sing(){
        System.out.println("singing...");
    }

    static int sum (int[] array){
        return Arrays.stream(array).reduce((a,b) -> a+b).getAsInt();
    }
}
