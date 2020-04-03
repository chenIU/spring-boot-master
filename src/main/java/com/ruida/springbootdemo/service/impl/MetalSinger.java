package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.service.ISinger;
import org.springframework.stereotype.Service;

/**
 * @description: 摇滚歌手
 * @author: chenjy
 * @create: 2020-03-30 13:55
 */
@Service
public class MetalSinger implements ISinger {
    @Override
    public void sing() {
        System.out.println("Metal singer is singing......");
    }
}
