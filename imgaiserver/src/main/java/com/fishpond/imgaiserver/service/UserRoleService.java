package com.fishpond.imgaiserver.service;

import com.fishpond.imgaiserver.mapper.UserRoleMapper;
import com.fishpond.imgaiserver.model.Role;
import com.fishpond.imgaiserver.model.User;
import com.fishpond.imgaiserver.model.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    public int addUserRole(UserRole userRole){
        return userRoleMapper.addUserRole(userRole);
    }
    public int removeUserRoleByUid(int uid){
        if(userService.getUserById(uid)==null){
           return userRoleMapper.removeUserRoleByUid(uid);
        }else {
            return -1;
        }
    }
    public int removeUserRoleByRid(int rid){
        if(roleService.getRoleById(rid)==null){
            return userRoleMapper.removeUserRoleByRid(rid);
        }else {
            return -1;
        }
    }
    public int removeUserRoleByUidAndRid(int uid,int rid){
        return userRoleMapper.removeUserRoleByUidAndRid(uid,rid);
    }
    public List<User> getUsersByRid(int rid){
        return userRoleMapper.getUsersByRid(rid);
    }
    public List<Role> getRolesByUid(int uid){
        return userRoleMapper.getRolesByUid(uid);
    }
}
