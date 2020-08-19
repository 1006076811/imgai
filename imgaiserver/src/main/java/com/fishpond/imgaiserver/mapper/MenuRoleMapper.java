package com.fishpond.imgaiserver.mapper;

import com.fishpond.imgaiserver.model.Menu;
import com.fishpond.imgaiserver.model.MenuRole;
import com.fishpond.imgaiserver.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRoleMapper {
    public int addMenuRole(MenuRole menuRole);
    public int deleteMenuRoleByMid(@Param("mid")int mid);
    public int deleteMenuRoleByMidAndRid(@Param("mid")int mid,@Param("rid")int rid);
    public List<Integer> getMidsByRid(@Param("rid") int rid);
    public List<Integer> getRidsByMid(@Param("mid") int mid);
}
