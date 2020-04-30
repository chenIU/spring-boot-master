package com.ruida.springbootdemo.mapper;

import com.ruida.springbootdemo.entity.User;

import java.util.List;

public interface UserMapper {

    User selectUserById(Integer id);

    List<User> selectAllUserList();

}
