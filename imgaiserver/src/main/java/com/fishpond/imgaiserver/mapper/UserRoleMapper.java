package com.fishpond.imgaiserver.mapper;

import com.fishpond.imgaiserver.model.Role;
import com.fishpond.imgaiserver.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
    public List<User> getUsersByRid(@Param("rid") int rid);
    public List<Role> getRolesByUid(@Param("uid") int uid);
}
