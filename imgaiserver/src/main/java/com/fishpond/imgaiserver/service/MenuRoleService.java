package com.fishpond.imgaiserver.service;

import com.fishpond.imgaiserver.mapper.MenuRoleMapper;
import com.fishpond.imgaiserver.model.MenuRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuRoleService {
    @Autowired
    MenuRoleMapper menuRoleMapper;
    public int addMenuRole(MenuRole menuRole){
        return menuRoleMapper.addMenuRole(menuRole);
    }
    public int deleteMenuRoleByMid(int mid){
        return menuRoleMapper.deleteMenuRoleByMid(mid);
    }
    public int deleteMenuRoleByMidAndRid(int mid,int rid){
        return menuRoleMapper.deleteMenuRoleByMidAndRid(mid,rid);
    }
    public List<Integer> getMidsByRid(int rid){
        return menuRoleMapper.getMidsByRid(rid);
    }
    public List<Integer> getRidsByMid(int mid){
        return menuRoleMapper.getRidsByMid(mid);
    }
}
