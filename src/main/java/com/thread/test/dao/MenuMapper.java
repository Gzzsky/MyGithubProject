package com.thread.test.dao;

import com.thread.test.bean.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuMapper {

    /**
     *
     * @return
     */
    List<Menu> getMenu();
}
