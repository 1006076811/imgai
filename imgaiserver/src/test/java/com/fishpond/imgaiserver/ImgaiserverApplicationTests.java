package com.fishpond.imgaiserver;

import com.fishpond.imgaiserver.mapper.RoleMapper;
import com.fishpond.imgaiserver.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImgaiserverApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.getUserById(1));
        System.out.println(roleMapper.getRoleById(1));
    }

}
