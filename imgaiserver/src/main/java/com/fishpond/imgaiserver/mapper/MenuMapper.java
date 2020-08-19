package com.fishpond.imgaiserver.mapper;

import com.fishpond.imgaiserver.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    public int addMenu(Menu menu);
    public int addMenuSelective(Menu menu);
    public int removeMenuById(@Param("id")int id);
    public int updateMenuById(Menu menu);
    public int updateMenuSelectiveById(Menu menu);
    public List<Menu> getMenusByUid(@Param("uid")int uid);
    public List<Menu> getAllMenus();
    public List<Menu> getAllMenusWithChild();
    public List<Menu> getAllMenusWithRole();

}
