package com.ruida.springbootdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.mapper.UserMapper;
import com.ruida.springbootdemo.service.UserService;
import com.ruida.springbootdemo.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-04-27 15:16
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;
    @Resource
    RedisUtil redisUtil;

    @Override
    @Transactional
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public PageInfo<User> selectAllUserListForPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userMapper.selectAllUserList();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Map<String, Object> selectDeptById(Integer id) {
        return userMapper.selectDeptById(id);
    }

    @Override
    public Integer countUser() {
        return userMapper.countUser();
    }

    @Override
    public List<User> queryAllUser() {
        List list;
        if(redisUtil.hasKey("userList")){
            log.warn("从redis中获取数据...");
            list = redisUtil.lGet("userList",0,-1);
        }else {
            log.warn("从数据库获取数据...");
            list = userMapper.selectAllUserList();
            log.warn("将数据存入redis...");
            redisUtil.lSet("userList",list,600);
            log.warn("成功存入redis...");
        }
        return list;
    }

}