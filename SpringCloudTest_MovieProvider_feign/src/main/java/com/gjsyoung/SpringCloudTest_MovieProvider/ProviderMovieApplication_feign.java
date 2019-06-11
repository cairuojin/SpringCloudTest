package com.gjsyoung.SpringCloudTest_MovieProvider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMovieApplication_feign {

	public static void main(String[] args) {
		SpringApplication.run(ProviderMovieApplication_feign.class, args);
	}

}
