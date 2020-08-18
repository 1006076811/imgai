package com.fishpond.imgaiserver.mapper;

import com.fishpond.imgaiserver.model.Role;
import com.fishpond.imgaiserver.model.User;
import com.fishpond.imgaiserver.model.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleMapper {
    public int addUserRole(UserRole userRole);
    public int removeUserRoleByUid(@Param("uid")int uid);
    public int removeUserRoleByRid(@Param("rid")int rid);
    public int removeUserRoleByUidAndRid(@Param("uid")int uid,@Param("rid")int rid);
    public List<User> getUsersByRid(@Param("rid") int rid);
    public List<Role> getRolesByUid(@Param("uid") int uid);
}
