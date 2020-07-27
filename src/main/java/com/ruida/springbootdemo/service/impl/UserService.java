package com.ruida.springbootdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.mapper.UserMapper;
import com.ruida.springbootdemo.service.IUserService;
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
public class UserService implements IUserService {

    @Resource
    UserMapper userMapper;

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

}
