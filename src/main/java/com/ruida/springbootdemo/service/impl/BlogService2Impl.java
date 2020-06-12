package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.service.BlogService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-06-12 09:11
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class BlogService2Impl implements BlogService2 {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void delete(int id) {
        String sql = "delete from blog where id=?";
        jdbcTemplate.update(sql, id);
        //throw new RuntimeException("出现异常");
    }
}
