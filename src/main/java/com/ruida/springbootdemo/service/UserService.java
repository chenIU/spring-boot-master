package com.ruida.springbootdemo.service;

import com.github.pagehelper.PageInfo;
import com.ruida.springbootdemo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User selectUserById(Integer id);

    PageInfo<User> selectAllUserListForPage(Integer pageNum,Integer pageSize);

    int insertUser(User user);

    Map<String,Object> selectDeptById(Integer id);

    Integer countUser();

    List<User> queryAllUser();

}
