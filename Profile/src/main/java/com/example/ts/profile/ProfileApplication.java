package com.example.ts.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = { "com.example.ts.profile.service" })
@ComponentScan(basePackages = { "com.example.ts.profile.repository" })
public class ProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
	}

}
