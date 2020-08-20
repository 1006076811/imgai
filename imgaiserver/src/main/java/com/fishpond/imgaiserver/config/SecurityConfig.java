package com.fishpond.imgaiserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fishpond.imgaiserver.model.User;
import com.fishpond.imgaiserver.service.UserService;
import com.fishpond.imgaiserver.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomFilterInvocationSecurityMataSource mataSource;
    @Autowired
    private CustomUrlDecisionManager decisionManager;

    //返回session注册器
    @Bean
    SessionRegistryImpl sessionRegistry(){
        return new SessionRegistryImpl();
    }

    //自定义的登录验证
    @Bean
    LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();

        //处理成功的响应
        loginFilter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=UTF-8");//格式为json
                PrintWriter writer = httpServletResponse.getWriter();
                User user = (User) authentication.getPrincipal();//将登录的用户提出来
                user.setPassword("");//这个数据是要返回给前端的，将敏感信息清除掉
                RespBean respOk = RespBean.ok("登录成功", user);
                String s = new ObjectMapper().writeValueAsString(respOk);
                writer.write(s);
                writer.flush();
                writer.close();
            }
        });
        //处理失败
        loginFilter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = httpServletResponse.getWriter();
                RespBean error = RespBean.error(e.getMessage());
                if(e instanceof BadCredentialsException){
                    error.setMsg("用户名或密码错误,请重新输入!");
                }else if(e instanceof UsernameNotFoundException){
                    error.setMsg("用户不存在,请重新输入!");
                }else if(e instanceof LockedException){
                    error.setMsg("账号被锁定，请联系管理员!");
                }else {
                    error.setMsg("未知错误");
                    System.out.println("登录错误:"+e.getMessage());
                }
                writer.write(new ObjectMapper().writeValueAsString(error));
                writer.flush();
                writer.close();
            }
        });
        //提供身份验证管理器
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        //设置登录的请求路径
        loginFilter.setFilterProcessesUrl("/login");
        ConcurrentSessionControlAuthenticationStrategy strategy = new ConcurrentSessionControlAuthenticationStrategy(sessionRegistry());
        strategy.setMaximumSessions(1);//设置只允许同时最多一个用户session在线
        loginFilter.setSessionAuthenticationStrategy(strategy);
        return loginFilter;
    }


    //身份管理器,用于获取用户信息
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //忽略这些目录和文件不进行身份验证
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/index.html", "/img/**", "/fonts/**", "/favicon.ico", "/verifyCode");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setAccessDecisionManager(decisionManager);
                o.setSecurityMetadataSource(mataSource);
                return o;
            }
        })
                .and()
                .logout().logoutUrl("/logout").permitAll()
                .and()
                .csrf().disable();

        //将session策略添加进去
        http.addFilterAt(new ConcurrentSessionFilter(sessionRegistry(), new SessionInformationExpiredStrategy() {
            @Override
            public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
                HttpServletResponse response = event.getResponse();
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(401);
                PrintWriter writer = response.getWriter();
                writer.write(new ObjectMapper().writeValueAsString(RespBean.error(401,"您已在另一台设备登录，本次登录已下线！",null)));
                writer.flush();
                writer.close();
            }
        }),ConcurrentSessionFilter.class);
        http.addFilterAt(this.loginFilter(), UsernamePasswordAuthenticationFilter.class);//将自定义的登录验证织入
    }
}
