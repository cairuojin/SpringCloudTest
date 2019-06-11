package com.gjsyoung.SpringCloudTest_UserProvider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomerUserDetailsService customerUserDetailsService;

    /**
     * 配置请求加密
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //所有的请求都通过HttpBasic
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

    /**
     * 配置用户登录
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customerUserDetailsService).passwordEncoder(this.passwordEncoder());
    }

    /**
     * 不做密码加密
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 模拟取用户过程
     */
    @Component
    class CustomerUserDetailsService implements UserDetailsService{
        @Override
        public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            List<GrantedAuthority> userRole = new ArrayList<>();
            userRole.add(new SimpleGrantedAuthority("user-role"));
            List<GrantedAuthority> adminRole = new ArrayList<>();
            adminRole.add(new SimpleGrantedAuthority("admin-role"));
            if("user".equals(s)){
                return new User("user","111111",userRole);
            } else if("admin".equals(s)){
                return new User("admin","123456",adminRole);
            } else {
                return null;
            }
        }
    }
}
