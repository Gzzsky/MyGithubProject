package com.thread.test.config;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GolbalExceptionResolver implements HandlerExceptionResolver {
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    ModelAndView mav = new ModelAndView();
    ex.printStackTrace();
    if(ex instanceof UnknownAccountException) {
      mav.setViewName("login");
      mav.addObject("message", "该用户名不存在，请重新输入");
    }else if(ex instanceof IncorrectCredentialsException) {
      mav.setViewName("login");
      mav.addObject("message", "用户名或密码错误，请重新输入");
    }else if(ex instanceof UnauthorizedException) {
      mav.setViewName("error");
      mav.addObject("message", "没有访问权限？点击开通VIP立即获取>>");
    }
    else {
      mav.setViewName("error");
      mav.addObject("message", "条子来了");
    }
    return mav;
  }
}
