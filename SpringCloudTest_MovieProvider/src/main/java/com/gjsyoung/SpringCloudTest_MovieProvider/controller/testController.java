package com.gjsyoung.SpringCloudTest_MovieProvider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class testController {


    @RequestMapping("/movie")
    public ModelAndView movieTest(){
        ModelAndView mav = new ModelAndView("test");
        System.out.println("aaa");
        System.out.println("aaa");
        System.out.println("aaa");
        System.out.println("aaa");
        return mav;
    }
}
