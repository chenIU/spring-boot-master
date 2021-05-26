package com.ruida.springbootdemo.generic;

/**
 * @description: 泛型类
 * 1.把泛型定义在类上
 * 2.类型变量定义在类上，方法中也可以使用
 * 3.在实例化泛型类时，必须指定T的具体类型
 * 4.泛型的类型参数只能是类类型，不能是简单类型
 * @author: chenjy
 * @create: 2020-09-30 16:20
 */
public class Generic<T> {

    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Generic() {
    }

    public Generic(T key) {
        this.key = key;
    }

    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明(将这个方法定义成泛型方法)
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以
     * @param t
     * @param <T>
     */
    public static <T> void show(T t){

    }
}
