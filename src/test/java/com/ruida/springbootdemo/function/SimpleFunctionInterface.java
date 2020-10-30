package com.ruida.springbootdemo.function;

public interface SimpleFunctionInterface<T> {
    T accept(T t);
}
