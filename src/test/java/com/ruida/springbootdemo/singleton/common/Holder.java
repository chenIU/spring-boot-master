package com.ruida.springbootdemo.singleton.common;

/**
 * @desc 静态内部类
 * @author chenjy
 * @since 2021/1/3 9:41
 */
public class Holder {

    private Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.instance;
    }

    public static class InnerClass{
        private static final Holder instance = new Holder();
    }

}
