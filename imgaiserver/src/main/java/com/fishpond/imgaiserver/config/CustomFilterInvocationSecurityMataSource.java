package com.fishpond.imgaiserver.config;

import com.fishpond.imgaiserver.model.Menu;
import com.fishpond.imgaiserver.model.Role;
import com.fishpond.imgaiserver.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 *  自定义权限管理器
 *  用于提取数据库内设置的url相应的权限，设置到security内，用于用户之后角色权限匹配
 *  当访问一个url时，这个就返回此url所需要的角色信息,动态实现权限管理
 */
@Component
public class CustomFilterInvocationSecurityMataSource implements FilterInvocationSecurityMetadataSource {
    //用于获取数据库内的url信息
    @Autowired
    private MenuService menuService;
    //用于匹配url
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //强转成FilterInvocation，这个类里面存了request和resp,还有一些FilterChain，很好用
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //获取所有url，用来匹配
        List<Menu> allMenusWithRole = menuService.getAllMenusWithRole();
        for (Menu menu : allMenusWithRole) {
            //如果匹配上了，就把他需要的角色信息提取出来，return
            if(antPathMatcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles = menu.getRoles();
                String[] rs = new String[roles.size()];
                for(int i=0;i<rs.length;i++){
                    rs[i]=roles.get(i).getName();
                }
                return SecurityConfig.createList(rs);
            }
        }
        //如果走到这里，说明没有匹配到，则允许匿名访问
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
