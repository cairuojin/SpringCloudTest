package com.gjsyoung.SpringCloudTest_MovieProvider.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义Ribbon负载均衡规则
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
