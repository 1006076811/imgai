package com.fishpond.imgaiserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fishpond.imgaiserver.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义登录验证规则
 */
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //登录只允许post方式
        if(!request.getMethod().equals("POST")){
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        //判断请求是否为json
        if(request.getContentType().contains(MediaType.APPLICATION_JSON_VALUE) || request.getContentType().contains(MediaType.APPLICATION_JSON_UTF8_VALUE)){
            Map<String,String> loginData = new HashMap<>(); //用于存放用户登录信息的键值对
            try {
                //读进信息
                loginData = new ObjectMapper().readValue(request.getInputStream(),Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String username = loginData.get(getUsernameParameter());
            String password = loginData.get(getPasswordParameter());
            if(username==null){
                username="";
            }
            if(password==null){
                password="";
            }
            username = username.trim();
            System.out.println("username"+username);
            System.out.println("password"+password);
            //开始验证
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            this.setDetails(request,token);
            //注册session
            User user = new User();
            user.setName(username);
            sessionRegistry.registerNewSession(request.getSession().getId(),user);
            return this.getAuthenticationManager().authenticate(token);//提交令牌
        }else {
            return super.attemptAuthentication(request,response); //若非json形式，直接用父类方法
        }
    }
}
