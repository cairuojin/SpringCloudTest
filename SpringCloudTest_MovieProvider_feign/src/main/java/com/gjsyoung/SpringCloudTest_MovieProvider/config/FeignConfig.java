package com.gjsyoung.SpringCloudTest_MovieProvider.config;

import feign.Contract;
import feign.Feign;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FeignConfig {

    /**
     * 修改日志级别为FULL
     * @return
     */
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }

}
