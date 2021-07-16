package com.ruida.springbootdemo.service;

import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.entity.result.MapResult;

import java.util.List;
import java.util.Map;

public interface UserService {

    User selectUserById(Integer id);

    int insertUser(User user);

    Map<String,Object> selectDeptById(Integer id);

    Integer countUser();

    List<User> queryAllUser();

    User queryUserById(String userId);

    MapResult<String,String> login(String username, String password);

    Integer insertNameAndAge(String username,int age);

    List<User> selectAllUsers(String orderBy);

    User getUserWithCache(Integer userId);

    void update(User user);
}
