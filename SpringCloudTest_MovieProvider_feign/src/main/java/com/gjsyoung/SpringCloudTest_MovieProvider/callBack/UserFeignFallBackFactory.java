package com.gjsyoung.SpringCloudTest_MovieProvider.callBack;

import com.gjsyoung.SpringCloudTest_MovieProvider.domain.User;
import com.gjsyoung.SpringCloudTest_MovieProvider.service.UserFeignCline;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserFeignFallBackFactory implements FallbackFactory<UserFeignCline> {
    @Override
    public UserFeignCline create(Throwable throwable) {
        return new UserFeignCline() {
            @Override
            public User getUser(Long id) {
                System.out.println("回退原因是：" + throwable);
                User user = new User();
                user.setId(0L);
                user.setAge(0);
                user.setName("默认用户");
                user.setUsername("default");
                return user;
            }
        };
    }
}
