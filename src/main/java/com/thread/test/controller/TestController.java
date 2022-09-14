package com.thread.test.controller;

import com.thread.test.bean.Account;
import com.thread.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

  @Autowired
  private AccountService accountService;

  @RequestMapping("/hello")
  @ResponseBody
  public String hellow(){
    return "hellow";
  }

  @RequestMapping("/getAccount")
  @ResponseBody
  public Account getAccount(){
    System.out.println("123");
    return accountService.findByUsername("zs");
  }
}
