package com.ruida.springbootdemo.service;

import com.github.pagehelper.PageInfo;
import com.ruida.springbootdemo.entity.User;

import java.util.Map;

public interface IUserService {

    User selectUserById(Integer id);

    PageInfo<User> selectAllUserListForPage(Integer pageNum,Integer pageSize);

    int insertUser(User user);

    Map<String,Object> selectDeptById(Integer id);

    Integer countUser();

}
