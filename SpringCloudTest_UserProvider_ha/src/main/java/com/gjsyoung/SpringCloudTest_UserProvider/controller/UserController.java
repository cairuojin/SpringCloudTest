package com.gjsyoung.SpringCloudTest_UserProvider.controller;

import com.gjsyoung.SpringCloudTest_UserProvider.dao.UserRepository;
import com.gjsyoung.SpringCloudTest_UserProvider.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            for(GrantedAuthority grantedAuthority : authorities){
                //打印当前用户
                System.out.println(user.getUsername() + " " + user.getPassword() + " " + grantedAuthority.getAuthority());
            }
        }


        User one = userRepository.findOne(id);
        return one;
    }
}
