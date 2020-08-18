package com.fishpond.imgaiserver.service;

import com.fishpond.imgaiserver.mapper.RoleMapper;
import com.fishpond.imgaiserver.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    public int addRole(Role role){
        return roleMapper.addRole(role);
    }
    public int removeRoleById(int id){
        return roleMapper.removeRoleById(id);
    }
    public int updateRoleById(Role role){
        return roleMapper.updateRoleById(role);
    }
    public int updateRoleSelectiveById(Role role){
        return roleMapper.updateRoleSelectiveById(role);
    }
    public Role getRoleById(int id){
        return roleMapper.getRoleById(id);
    }
    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    }
}
