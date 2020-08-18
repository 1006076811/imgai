package com.fishpond.imgaiserver.mapper;

import com.fishpond.imgaiserver.model.Role;
import com.fishpond.imgaiserver.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public int addUser(User user);
    public int removeUserById(@Param("id") int id);
    public int updateUserById(User user);
    //选择性的修改数据
    public int updateUserSelectiveById(User user);
    //获取用户(无角色信息)
    public User getUserById(@Param("id") int id);
    public List<User> getAllUser();
    //获取用户(有角色信息)
    public User getUserWithRolesByUid(@Param("id") int id);
    public List<User> getAllUserWithRoles();
}
