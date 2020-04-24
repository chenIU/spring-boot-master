package com.ruida.springbootdemo.entity.singleton;

public enum Singleton5 {

    INSTANCE;

    //doSomething 该实例支持的行为

    //可以省略此方法，通过Singleton.INSTANCE进行操作
    public static Singleton5 getInstance() {
        return Singleton5.INSTANCE;
    }

}
