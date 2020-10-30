package com.ruida.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruida.springbootdemo.constant.JwtConstants;
import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.entity.result.MapResult;
import com.ruida.springbootdemo.mapper.UserMapper;
import com.ruida.springbootdemo.service.UserService;
import com.ruida.springbootdemo.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-04-27 15:16
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;

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
        if(redisTemplate.hasKey("userList")){
            log.warn("从redis中获取数据...");
            list = redisTemplate.opsForList().range("userList",0,-1);
        }else {
            log.warn("从数据库获取数据...");
            list = userMapper.selectAllUserList();
            log.warn("将数据存入redis...");
            redisTemplate.opsForList().leftPush("userList",list);
            log.warn("成功存入redis...");
        }
        return list;
    }

    @Override
    public User queryUserById(String userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public MapResult<String,String> login(String username, String password) {

        //手动设置redisTemplate key的序列化方式
        //redisTemplate.setKeySerializer(new StringRedisSerializer());

        MapResult<String, String> map = new MapResult<>();
        HashMap<String, String> payload = new HashMap<>();

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",username).eq("password",password);
        User user = userMapper.selectOne(wrapper);
        if(user != null){
            payload.put("userId",String.valueOf(user.getId()));
            payload.put("username",username);
            String token = JwtUtil.getToken(payload);

            //将token信息放入redis
            String key = String.format(JwtConstants.TOKEN_KEY, user.getId());
            redisTemplate.opsForValue().set(key,token);
            redisTemplate.expire(key,JwtConstants.EXPIRATION, TimeUnit.SECONDS);//7天后过期

            map.add("token",token);
            map.setErrorMsg("登录成功!");
            map.setSuccess(true);
        }else {
            map.setErrorMsg("用户名或密码错误!");
            map.setSuccess(false);
        }
        return map;
    }

    @Override
    public Integer insertNameAndAge(String username, int age) {
        return userMapper.insertNameAndAge(username,age);
    }

    @Override
    public List<User> selectAllUsers(String orderBy) {
        return userMapper.selectAllUsers(orderBy);
    }
}
