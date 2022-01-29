package com.ba.zuul.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BankapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankapigatewayApplication.class, args);
	}

}
