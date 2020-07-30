package com.ruida.springbootdemo.controller.redis;

import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-07-30 11:30
 */
@RestController
@RequestMapping("/redis/")
public class RedisController {

    @Resource
    UserService userService;

    @RequestMapping("queryAllUser")
    public List<User> queryAllUser(){
        return userService.queryAllUser();
    }

}
