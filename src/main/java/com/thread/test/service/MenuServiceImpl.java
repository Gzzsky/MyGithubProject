package com.thread.test.service;

import com.thread.test.bean.Menu;
import com.thread.test.dao.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

  @Autowired
  private MenuMapper menuMapper;

  @Override
  public List<Menu> getMenu() {
    return menuMapper.getMenu();
  }
}