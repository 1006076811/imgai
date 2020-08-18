package com.fishpond.imgaiserver;

import com.fishpond.imgaiserver.mapper.ImageMapper;
import com.fishpond.imgaiserver.mapper.RoleMapper;
import com.fishpond.imgaiserver.mapper.UserMapper;
import com.fishpond.imgaiserver.mapper.UserRoleMapper;
import com.fishpond.imgaiserver.model.Image;
import com.fishpond.imgaiserver.model.Role;
import com.fishpond.imgaiserver.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ImgaiserverApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    ImageMapper imageMapper;
    @Test
    void contextLoads() {
        List<Role> rolesByUid = userRoleMapper.getRolesByUid(1);
        for (Role role : rolesByUid) {
            System.out.println(role);
        }
    }

}
