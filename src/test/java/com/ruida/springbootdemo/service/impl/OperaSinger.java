package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.service.ISinger;
import org.springframework.stereotype.Service;

/**
 * @description: 话剧歌手
 * @author: chenjy
 * @create: 2020-03-30 13:53
 */
@Service
public class OperaSinger implements ISinger {

    @Override
    public void sing() {
        System.out.println("Opera singer is singing......");
    }

}
