package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.mapper.UserMapper;
import com.ruida.springbootdemo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-04-27 15:16
 */
@Service
public class UseService implements IUserService {

    @Resource
    UserMapper userMapper;

    @Override
    @Transactional
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

}
