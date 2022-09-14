package com.thread.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages	= {"com.thread.test.dao"})
public class MainApp {

  public static void main(String[] args) {
    SpringApplication.run(MainApp.class, args);
  }
}