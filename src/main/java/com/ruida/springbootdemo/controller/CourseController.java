package com.ruida.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-04-27 14:33
 */
@RestController
@RequestMapping("")
public class CourseController {

    @RequestMapping(value = "/getCourseInfo",method = RequestMethod.GET)
    public String getCourseInfo(){
        return "hello course controller";
    }

}
