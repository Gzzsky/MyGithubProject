package com.thread.test.dao;

import com.thread.test.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper{

    /**
     *
     * @param username
     * @return
     */
    Account getAccountByUsername(String username);
}
