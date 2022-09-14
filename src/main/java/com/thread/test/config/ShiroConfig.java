package com.thread.test.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

  @Bean
  public ShiroFilterFactoryBean filterFactoryBean(@Qualifier("manager") DefaultWebSecurityManager manager){
    ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
    factoryBean.setSecurityManager(manager);

    Map<String,String> map = new HashMap<>();
    map.put("/page/*","authc");
    map.put("/manage","perms[manage]");
    map.put("/administrator","roles[administrator]");
    factoryBean.setFilterChainDefinitionMap(map);

//    factoryBean.setUnauthorizedUrl("/toLogin");

    //设置登录页面
    factoryBean.setLoginUrl("/login");
    //未授权页面
    factoryBean.setUnauthorizedUrl("/unauth");

    return factoryBean;
  }


  @Bean
  public DefaultWebSecurityManager manager(@Qualifier("myRealm") MyRealm myRealm){
    DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
    manager.setRealm(myRealm);
    return manager;
  }

  @Bean
  public MyRealm myRealm(){
    return new MyRealm();
  }

  @Bean
  public ShiroDialect shiroDialect(){
    return new ShiroDialect();
  }

  /**
   * 注册全局异常处理
   * @return
   */
  @Bean(name = "exceptionHandler")
  public HandlerExceptionResolver handlerExceptionResolver(){
    return new GolbalExceptionResolver();
  }
}