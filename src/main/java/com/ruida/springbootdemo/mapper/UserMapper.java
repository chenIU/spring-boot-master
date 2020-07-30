package com.ruida.springbootdemo.mapper;

import com.ruida.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;

import java.util.List;
import java.util.Map;

@CacheConfig(cacheNames = "user")
public interface UserMapper {

    @CachePut(key = "#p0")
    User selectUserById(@Param("id") Integer id);

    List<User> selectAllUserList();

    @Insert("insert into t_user(name,age,dept_id) values(#{name},#{age},#{dept_id})")
    int insertUser(User user);

    Map<String,Object> selectDeptById(Integer id);

    int countUser();

}
