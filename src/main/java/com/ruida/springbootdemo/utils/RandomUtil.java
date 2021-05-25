package com.ruida.springbootdemo.utils;

import com.ruida.springbootdemo.exception.BaseException;

import java.util.Random;

/**
 * @author Chen.J.Y
 * @date 2021/5/25
 */
public class RandomUtil {

    /**
     * 生成指定范围内的随机数
     * 包含头，不包含尾
     */
    public static Integer getRandomInt(int start, int end) {
        if (start >= end) {
            throw new BaseException(500, "数值范围不符合要求");
        }
        return new Random().nextInt(end - start) + start;
    }
}
