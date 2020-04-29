package com.ruida.springbootdemo.service;

import com.github.pagehelper.PageInfo;
import com.ruida.springbootdemo.entity.User;

public interface IUserService {

    User selectUserById(Integer id);

    PageInfo<User> selectAllUserListForPage(Integer pageNum,Integer pageSize);

}
