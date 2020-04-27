package com.ruida.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("test")
    public String test(){
        return "market test......";
    }

    @GetMapping("hello")
    public String hello(){
        return "hello spring boot";
    }

    @GetMapping("dev")
    public String dev(){
        return "dev commit something...";
    }

}
