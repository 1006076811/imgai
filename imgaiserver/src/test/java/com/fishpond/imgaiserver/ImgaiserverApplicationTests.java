package com.fishpond.imgaiserver;

import com.fishpond.imgaiserver.mapper.*;
import com.fishpond.imgaiserver.model.Image;
import com.fishpond.imgaiserver.model.Menu;
import com.fishpond.imgaiserver.model.Role;
import com.fishpond.imgaiserver.model.User;
import com.fishpond.imgaiserver.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ImgaiserverApplicationTests {

   @Autowired
    MenuService menuService;
    @Test
    void contextLoads() {
        List<Menu> allMenusWithRole = menuService.getAllMenusWithRole();
        for (Menu menu : allMenusWithRole) {
            System.out.println(menu);
        }
    }

}
