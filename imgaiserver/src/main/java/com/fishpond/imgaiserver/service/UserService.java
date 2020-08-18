package com.fishpond.imgaiserver.service;

import com.fishpond.imgaiserver.mapper.RoleMapper;
import com.fishpond.imgaiserver.mapper.UserMapper;
import com.fishpond.imgaiserver.mapper.UserRoleMapper;
import com.fishpond.imgaiserver.model.Image;
import com.fishpond.imgaiserver.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.getUserWithRolesByUsername(s);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        if(user.getRoles()==null){
            user.setRoles(userRoleMapper.getRolesByUid(user.getId()));
        }
        return user;
    }
    public int addUser(User user){
        return userMapper.addUser(user);
    }
    public int removeUserById(int id){
        return userMapper.removeUserById(id);
    }
    public int updateUserById(User user){
        return userMapper.updateUserById(user);
    }
    public int updatePassword(int uid,String oldPswd,String newPswd){
        User user = userMapper.getUserById(uid);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(oldPswd,user.getPassword())){
            user.setPassword(encoder.encode(newPswd));
        }
        return userMapper.updateUserSelectiveById(user);
    }

    //选择性的修改数据
    public int updateUserSelectiveById(User user){
        return userMapper.updateUserSelectiveById(user);
    }
    //获取用户(无角色信息)
    public User getUserById(int id){
        return userMapper.getUserById(id);
    }
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
    //获取用户(有角色信息)
    public User getUserWithRolesByUid(int id){
        return userMapper.getUserWithRolesByUid(id);
    }
    public List<User> getAllUserWithRoles(){
        return userMapper.getAllUserWithRoles();
    }
    //获取用户上传过的图片
    public List<Image> getImageByUid(int uid){
        return userMapper.getImageByUid(uid);
    }
}
