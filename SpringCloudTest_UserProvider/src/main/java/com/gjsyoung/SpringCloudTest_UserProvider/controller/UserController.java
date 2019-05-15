package com.gjsyoung.SpringCloudTest_UserProvider.controller;

import com.gjsyoung.SpringCloudTest_UserProvider.dao.UserRepository;
import com.gjsyoung.SpringCloudTest_UserProvider.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/page/{id}")
    public ModelAndView findByIdPage(@PathVariable Long id){
        ModelAndView mav = new ModelAndView("userTest");
        User one = userRepository.findOne(id);
        mav.addObject("user",one);
        return mav;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User findById(@PathVariable Long id){
        User one = userRepository.findOne(id);
        return one;
    }

}
