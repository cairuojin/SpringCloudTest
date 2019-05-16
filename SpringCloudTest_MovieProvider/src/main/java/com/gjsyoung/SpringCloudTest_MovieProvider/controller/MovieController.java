package com.gjsyoung.SpringCloudTest_MovieProvider.controller;

import com.gjsyoung.SpringCloudTest_MovieProvider.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/movie")
    public ModelAndView movieTest(Integer id){
        ModelAndView mav = new ModelAndView("test");
        //远程调用并获取对象
        User user = restTemplate.getForObject("http://localhost/" + id, User.class);
        mav.addObject("user",user);
        return mav;
    }

    @ResponseBody
    @RequestMapping("/showInfo")
    public List<ServiceInstance> showInfo(){
        return discoveryClient.getInstances("SpringCloudTest_UserProvider");
    }
}
