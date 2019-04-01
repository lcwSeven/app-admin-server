package com.app.admin.server.config;

import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.common.UserUtil;
import com.app.admin.server.service.UserDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.io.PrintWriter;

/**
 * @author: liucaiwen
 * @date: 2019/3/25 22:29
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomMetadataSource metadataSource;
    @Autowired
    private UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    private UserDetailService userDetailsService;
    @Autowired
    private AuthenticationAccessDeniedHandler deniedHandler;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).
                passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**", "/login_p", "/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(metadataSource);
                o.setAccessDecisionManager(urlAccessDecisionManager);
                return o;
            }
        }).and().formLogin().loginPage("/login_p").loginProcessingUrl("/login")
                .usernameParameter("userName").passwordParameter("password")
                .failureHandler((request, response, e) -> {
                    response.setContentType("application/json;charset=utf-8");
                    ServerResponse respBean;
                    if (e instanceof BadCredentialsException ||
                            e instanceof UsernameNotFoundException) {
                        respBean = ServerResponse.buildByErrorMsg("账户名或者密码输入错误!");
                    } else if (e instanceof LockedException) {
                        respBean = ServerResponse.buildByErrorMsg("账户被锁定，请联系管理员!");
                    } else if (e instanceof CredentialsExpiredException) {
                        respBean = ServerResponse.buildByErrorMsg("密码过期，请联系管理员!");
                    } else if (e instanceof AccountExpiredException) {
                        respBean = ServerResponse.buildByErrorMsg("账户过期，请联系管理员!");
                    } else if (e instanceof DisabledException) {
                        respBean = ServerResponse.buildByErrorMsg("账户被禁用，请联系管理员!");
                    } else {
                        respBean = ServerResponse.buildByErrorMsg("登录失败!");
                    }
                    response.setStatus(401);
                    ObjectMapper om = new ObjectMapper();
                    PrintWriter out = response.getWriter();
                    out.write(om.writeValueAsString(respBean));
                    out.flush();
                    out.close();
                }).successHandler((request, response, auth) -> {
            response.setContentType("application/json;charset=utf-8");
            ServerResponse respBean = ServerResponse.buildBySuccess("登录成功!", UserUtil.getCurrentUser());
            ObjectMapper om = new ObjectMapper();
            PrintWriter out = response.getWriter();
            out.write(om.writeValueAsString(respBean));
            out.flush();
            out.close();
        })
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((request, response, auth) -> {
                    response.setContentType("application/json;charset=utf-8");
                    ServerResponse respBean = ServerResponse.buildBySuccess("注销成功!");
                    ObjectMapper om = new ObjectMapper();
                    PrintWriter out = response.getWriter();
                    out.write(om.writeValueAsString(respBean));
                    out.flush();
                    out.close();
                }).permitAll()
                .and().csrf().disable()
                .exceptionHandling().accessDeniedHandler(deniedHandler);
        ;
    }
}
