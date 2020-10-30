package com.ruida.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruida.springbootdemo.entity.Account;
import com.ruida.springbootdemo.mapper.AccountMapper;
import com.ruida.springbootdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findByUsername(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_name",username);
        return accountMapper.selectOne(wrapper);
    }
}
