package com.ruida.springbootdemo.service;

import com.ruida.springbootdemo.entity.User;

public interface IUserService {

    User selectUserById(Integer id);

}
