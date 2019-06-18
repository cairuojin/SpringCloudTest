package com.gjsyoung.SpringCloudTest_MovieProvider.callBack;

import com.gjsyoung.SpringCloudTest_MovieProvider.domain.User;
import com.gjsyoung.SpringCloudTest_MovieProvider.service.UserFeignCline;
import org.springframework.stereotype.Component;

@Component
public class UserFeignClientCallBack implements UserFeignCline{

    /**
     * 调用用户微服务容错方法
     * @param id
     * @return
     */
    @Override
    public User getUser(Long id) {
        System.out.println("容错方法启动  ");
        User user = new User();
        user.setId(0L);
        user.setAge(0);
        user.setName("默认用户");
        user.setUsername("default");
        return user;
    }
}
