package com.fishpond.imgaiserver;

import com.fishpond.imgaiserver.mapper.*;
import com.fishpond.imgaiserver.model.Image;
import com.fishpond.imgaiserver.model.Menu;
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
    @Autowired
    MenuMapper menuMapper;
    @Test
    void contextLoads() {
        List<Menu> allMenusWithRole = menuMapper.getAllMenusWithRole();
        for (Menu menu : allMenusWithRole) {
            System.out.println(menu);
        }
    }

}
