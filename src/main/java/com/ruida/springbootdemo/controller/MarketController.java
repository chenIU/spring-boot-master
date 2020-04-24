package com.ruida.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 营销控制器
 * @author: chenjy
 * @create: 2020-04-01 09:50
 */
@RestController
@RequestMapping("/market/")
public class MarketController {

    @RequestMapping("test")
    public String test(){
        return "market test......";
    }

    @RequestMapping("hello")
    public String hello(){
        return "hello spring boot";
    }

    @RequestMapping("dev")
    public String dev(){
        return "dev commit something...";
    }

}
