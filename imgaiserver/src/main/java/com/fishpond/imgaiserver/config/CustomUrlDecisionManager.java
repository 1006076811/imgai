package com.fishpond.imgaiserver.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 此类进行登录的角色访问url权限的处理和匿名访问的处理
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {

    //第一个参数为登录的角色信息，第二个参数可以转为FilterInvocation,第三个参数是此url的角色信息
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        //遍历url需要的角色信息
        for (ConfigAttribute configAttribute : configAttributes) {
            //因为一个url可能支持多种角色访问，因此需要遍历
            String needRole = configAttribute.getAttribute();
            //url所需要的角色信息处理在 CustomFilterInvocationSecurityMataSource里进行的处理，若可以匿名访问，则会为空
            if(needRole==null || "".equals(needRole)){
                return;//可以匿名访问，直接放行
            }
            //获取当前登录用户的角色信息
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if(authority.getAuthority().equals(needRole)){
                    return; //若角色匹配上了，则放行
                }
            }
        }
        //若走到这一步，说明无权访问此url
        throw new AccessDeniedException("访问权限不足！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
