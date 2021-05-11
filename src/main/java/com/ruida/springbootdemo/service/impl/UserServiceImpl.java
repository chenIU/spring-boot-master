package com.ruida.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    private RedisTemplate<String,Object> redisTemplate;

    private final static Cache<String,Object> CACHE = CacheBuilder.newBuilder()
            //设置cache的初始大小为10，要合理设置该值
            .initialCapacity(10)
            //设置并发数为5，即同一时间最多只能有5个线程往cache执行写入操作
            .concurrencyLevel(5)
            //设置cache中的数据在写入之后的存活时间为一天
            .expireAfterWrite(1,TimeUnit.DAYS)
            //构建实例
            .build();

    @Override
    @Transactional
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Map<String, Object> selectDeptById(Integer id) {
        return userMapper.selectDeptById(id);
    }

    @Override
    public Integer countUser() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String method = request.getMethod();
        log.warn("请求方法:{}",method);
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
            //7天后过期
            redisTemplate.expire(key,JwtConstants.EXPIRATION, TimeUnit.SECONDS);

            map.add("token",token);
            map.setMsg("登录成功!");
        }else {
            map.setMsg("用户名或密码错误!");
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

    @Override
    public User getUserWithCache(Integer userId){
        // 优先从缓存中获取
        Object cacheObj = CACHE.getIfPresent("userId:" + userId);
        if(cacheObj != null){
            return (User) cacheObj;
        }

        User user = userMapper.selectUserById(userId);
        CACHE.put("userId:" + userId , user);
        return user;
    }
}
