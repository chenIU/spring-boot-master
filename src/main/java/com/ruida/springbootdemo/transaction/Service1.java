package com.ruida.springbootdemo.transaction;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-06-04 10:51
 */
@Component
@Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
public class Service1 {

    public void hello(){
        System.out.println("hello...");
        throw new RuntimeException("hello throw error");
        //Course course = null;
        //course.getAuthor();
    }

}
