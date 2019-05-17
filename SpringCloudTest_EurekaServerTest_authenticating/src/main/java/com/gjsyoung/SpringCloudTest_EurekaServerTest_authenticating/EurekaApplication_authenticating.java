package com.gjsyoung.SpringCloudTest_EurekaServerTest_authenticating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication_authenticating {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication_authenticating.class,args);
    }
}
