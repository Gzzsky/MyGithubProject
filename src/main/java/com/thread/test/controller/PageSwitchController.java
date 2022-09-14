package com.thread.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageSwitchController {

  @GetMapping("dashboard.html")
  public String toDashboard(){
    return "page/dashboard";
  }

  @GetMapping("manage.html")
  public String toManage(){
    return "page/manage";
  }
}
