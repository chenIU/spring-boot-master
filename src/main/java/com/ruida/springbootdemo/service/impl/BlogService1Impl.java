package com.ruida.springbootdemo.service.impl;

import com.ruida.springbootdemo.entity.Blog;
import com.ruida.springbootdemo.service.BlogService1;
import com.ruida.springbootdemo.service.BlogService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: chenjy
 * @create: 2020-06-12 09:07
 */
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
@Service
public class BlogService1Impl implements BlogService1 {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    BlogService2 blogService2;

    @Override
    public void save(Blog blog) {
        String sql = "insert into t_blog values(?,?,?)";
        jdbcTemplate.update(sql,
                new Object[]{blog.getId(), blog.getName(), blog.getUrl()},
                new int[]{java.sql.Types.INTEGER, java.sql.Types.VARCHAR, java.sql.Types.VARCHAR});
        blogService2.delete(1);
        int i = 1/0;
    }

    @Override
    public void update(Blog blog) {
        String sql = "update t_blog set name = ? where id=?";
        jdbcTemplate.update(sql, new Object[]{blog.getName(), blog.getId()},
                new int[]{java.sql.Types.VARCHAR, java.sql.Types.INTEGER});
    }

}
