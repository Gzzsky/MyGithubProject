package com.thread.test.controller;

import com.thread.test.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MyController {

  @Autowired
  private MenuService menuService;

  @GetMapping("/{url}")
  public String redirect(@PathVariable("url") String url){
    return url;
  }

  @PostMapping("/toLogin")
  public String login(String username, String password, Model model){
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(username,password);
    try {
      subject.login(token);
      model.addAttribute("datas", menuService.getMenu());
      return "page/index";
    } catch (UnknownAccountException e) {
      model.addAttribute("msg","用户名错误");
      return "login";
    } catch (IncorrectCredentialsException e) {
      model.addAttribute("msg", "密码错误");
      return "login";
    }
  }

  @GetMapping("/logout")
  public String logout(){
    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    return "login";
  }

  @RequestMapping("/unauth")
  @ResponseBody
  public String unauth(){
    return "未授权没有访问权限";
  }
}