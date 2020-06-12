package com.ruida.springbootdemo.controller;

import com.ruida.springbootdemo.entity.Blog;
import com.ruida.springbootdemo.service.BlogService1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 事务传播属性
 * @author: chenjy
 * @create: 2020-06-12 09:23
 *
 * 总结：
 * **********************************************************************************************
 * 1)REQUIRED：如果有事务则加入事务，如果没有事务，则创建一个新的事务(默认值)
 * 2)NOT_SUPPORTED：spring不会当前方法开启事务，相当于没有事务
 * 3)REQUIRES_NEW：不管是否存在事务，都创建一个新的事务。原方法的事务挂起，新的方法实行完毕后，再执行老的事务
 * 4)MANDATORY：必须在一个已有的事务中执行，否则报错
 * 5)NEVER：不能在事务中执行，否则报错
 * 6)SUPPORTS：如果有事务，则在原事务中执行。如果没有事务，则不在事务中执行
 * 7)NESTED：如果存在事务，则在事务中嵌套执行。如果没有事务，则创建一个新的事务
 * **********************************************************************************************
 *
 * 注意事项：
 * 1)REQUIRED
 * 当两个方法的传播机制都是REQUIRED时，如果一旦发生回滚，则两个方法都会回滚
 * 2)REQUIRES_NEW
 * 当内层方法的事务传播属性是REQUIRES_NEW时，外层方法的回滚不会影响到内层方法
 * 3)NESTED
 * 当外层方法的事务传播属性是REQUIRED，内层方法是NESTED时，内层方法会开启一个嵌套事务。
 * 当外层方法回滚时，内层方法也会回滚；反之，内层方法回滚，不会影响到外层方法。
 */
@RestController
@RequestMapping("/tx/")
@Slf4j
public class TxController {

    @Autowired
    BlogService1 service1;

    @PostMapping("save")
    public void save(@RequestBody Blog blog){
        log.info("spring transaction ...");
        service1.save(blog);
    }

}
