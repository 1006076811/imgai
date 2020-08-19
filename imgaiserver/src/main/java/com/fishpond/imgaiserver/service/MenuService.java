package com.fishpond.imgaiserver.service;

import com.fishpond.imgaiserver.mapper.MenuMapper;
import com.fishpond.imgaiserver.model.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public int addMenu(Menu menu){
        return menuMapper.addMenu(menu);
    }
    public int addMenuSelective(Menu menu){
        return menuMapper.addMenuSelective(menu);
    }
    public int removeMenuById(int id){
        return menuMapper.removeMenuById(id);
    }
    public int updateMenuById(Menu menu){
        return menuMapper.updateMenuById(menu);
    }
    public int updateMenuSelectiveById(Menu menu){
        return menuMapper.updateMenuSelectiveById(menu);
    }
    public List<Menu> getMenusByUid(int uid){
        return menuMapper.getMenusByUid(uid);
    }
    public List<Menu> getAllMenus(){
        return menuMapper.getAllMenus();
    }
    public List<Menu> getAllMenusWithChild(){
        return menuMapper.getAllMenusWithChild();
    }
    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }
}
