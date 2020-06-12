package com.ruida.springbootdemo.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @description: spring事务测试
 * @author: chenjy
 * @create: 2020-06-04 10:49
 */
@Component
@Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRED)
public class SpringTx {

    @Resource
    Service1 s1;
    @Resource
    Service2 s2;

    public void transaction() {
        System.out.println("111");
        s1.hello();
        s2.eat();
        System.out.println("2222");
    }

}
