package com.gjsyoung.SpringCloudTest_MovieProvider.service;

import com.gjsyoung.SpringCloudTest_MovieProvider.callBack.UserFeignClientCallBack;
import com.gjsyoung.SpringCloudTest_MovieProvider.callBack.UserFeignFallBackFactory;
import com.gjsyoung.SpringCloudTest_MovieProvider.config.FeignConfig;
import com.gjsyoung.SpringCloudTest_MovieProvider.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        name = "SpringCloudTest-UserProvider",
        configuration = FeignConfig.class,
        //fallback = UserFeignClientCallBack.class,
        fallbackFactory = UserFeignFallBackFactory.class
)
public interface UserFeignCline {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Long id);

}
