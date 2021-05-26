package com.ruida.springbootdemo.controller.redis;

import com.ruida.springbootdemo.entity.User;
import com.ruida.springbootdemo.entity.result.CommonResult;
import com.ruida.springbootdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-07-30 11:30
 */
@Slf4j
@RestController
@RequestMapping("/redis/")
public class RedisController {

    @Resource
    UserService userService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;

    @RequestMapping(value = "queryAllUser",method = RequestMethod.GET)
    public List<User> queryAllUser(){
        //OrderService orderService  = SpringUtil.getBean(OrderService.class);
        //System.out.println(orderService);
        return userService.queryAllUser();
    }

    @GetMapping("distributedLock")
    public CommonResult distributedLock(){
        RLock lock = redissonClient.getLock("MoonCake");
        lock.lock();

        log.info("线程名称，{}",Thread.currentThread().getName());
        String stocks = (String) redisTemplate.opsForValue().get("stock");

        assert stocks != null;
        int stock = Integer.parseInt(stocks);

        try {
            if(stock > 0){
                stock -= 1;
                redisTemplate.opsForValue().set("stock", String.valueOf(stock));
                log.info("扣减成功，库存={}",stock);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return new CommonResult();
    }

}
