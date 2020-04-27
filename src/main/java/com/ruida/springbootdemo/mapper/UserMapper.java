package com.ruida.springbootdemo.mapper;

import com.ruida.springbootdemo.entity.User;

public interface UserMapper {

    User selectUserById(Integer id);

}
