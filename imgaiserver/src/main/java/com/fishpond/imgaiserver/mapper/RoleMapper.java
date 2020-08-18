package com.fishpond.imgaiserver.mapper;

import com.fishpond.imgaiserver.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    public int addRole(Role role);
    public int removeRoleById(@Param("id")int id);
    public int updateRoleById(Role role);
    public int updateRoleSelectiveById(Role role);
    public Role getRoleById(@Param("id")int id);
    public List<Role> getAllRoles();
}
