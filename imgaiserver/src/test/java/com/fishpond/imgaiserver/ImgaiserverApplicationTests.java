package com.fishpond.imgaiserver;

import com.fishpond.imgaiserver.mapper.RoleMapper;
import com.fishpond.imgaiserver.mapper.UserMapper;
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

    @Test
    void contextLoads() {
        Role role = new Role();
        role.setId(4);
        role.setName("hehe");
        role.setNameZh("呵呵");
        roleMapper.removeRoleById(4);
    }

}
