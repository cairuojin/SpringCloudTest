package com.gjsyoung.SpringCloudTest_MovieProvider.controller;

import com.gjsyoung.SpringCloudTest_MovieProvider.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    LoadBalancerClient loadBalancerClient;  //Ribbon负载均衡对象

    /**
     * 调用用户微服务
     * @param id
     * @return
     */
    @RequestMapping("/movie")
    public ModelAndView movieTest(Integer id){
        ModelAndView mav = new ModelAndView("test");
        //远程调用并获取对象
        User user = restTemplate.getForObject("http://SpringCloudTest-UserProvider/" + 1 , User.class);
        mav.addObject("user",user);
        return mav;
    }

    /**
     * 获取User微服务实例  打印获取到的是哪个实例
     */
    @GetMapping("/log-instance")
    @ResponseBody
    public void logUserInstance(){
        ServiceInstance userprovider = loadBalancerClient.choose("SpringCloudTest-UserProvider");
        System.out.println(userprovider.getServiceId() + " "
                + userprovider.getHost() + ":"
                + userprovider.getPort());
    }

    @ResponseBody
    @RequestMapping("/showInfo")
    public List<ServiceInstance> showInfo(){
        return discoveryClient.getInstances("SpringCloudTest-UserProvider");
    }
}
