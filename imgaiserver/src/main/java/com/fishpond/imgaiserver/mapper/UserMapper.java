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
    public User getUserById(@Param("id") int id);
    public List<User> getAllUser();
    public List<Role> getRolesByUid(@Param("id") int id);
}
