package com.fishpond.imgaiserver.mapper;

import com.fishpond.imgaiserver.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    public Role getRoleById(@Param("id")int id);
}
