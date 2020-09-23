package com.ruida.springbootdemo.controller.log;

import com.ruida.springbootdemo.annotation.AuthCheck;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-09-23 16:53
 */
@RestController
@RequestMapping("/log/")
@Slf4j
public class LogController {

    @AuthCheck
    @GetMapping("test")
    public String test(@Param("id") Integer id,@Param("name") String name){
        log.info("开始执行/log/test 方法");
        return id + name;
    }
}
