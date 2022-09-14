package com.thread.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
  private Integer id;
  private String title;
  private String className;
  private String createTime;
  private String path;
}
