package com.thread.test.service;

import com.thread.test.bean.Account;
import com.thread.test.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired
  private AccountMapper accountMapper;

  @Override
  public Account findByUsername(String username) {
    return accountMapper.getAccountByUsername(username);
  }
}