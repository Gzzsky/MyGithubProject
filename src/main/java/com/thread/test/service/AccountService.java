package com.thread.test.service;

import com.thread.test.bean.Account;

public interface AccountService {
  public Account findByUsername(String username);
}
