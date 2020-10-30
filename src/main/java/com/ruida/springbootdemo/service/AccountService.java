package com.ruida.springbootdemo.service;

import com.ruida.springbootdemo.entity.Account;

public interface AccountService {

    Account findByUsername(String username);
}
