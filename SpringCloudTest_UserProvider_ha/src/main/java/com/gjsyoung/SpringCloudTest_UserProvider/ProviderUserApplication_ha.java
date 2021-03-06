package com.gjsyoung.SpringCloudTest_UserProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderUserApplication_ha {

    public static void main(String[] args) {
        SpringApplication.run(ProviderUserApplication_ha.class, args);
    }
}
