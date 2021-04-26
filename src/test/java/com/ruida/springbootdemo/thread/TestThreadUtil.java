package com.ruida.springbootdemo.thread;

import cn.hutool.core.thread.ThreadUtil;

/**
 * @author Chen.J.Y
 * @date 2021/4/23
 */
public class TestThreadUtil {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ThreadUtil.execute(() ->
            System.out.println(Thread.currentThread().getName())
        );
    }
}
