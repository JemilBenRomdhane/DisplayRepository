package com.utina.core.display;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}, scanBasePackages = "com.utina.core")
@EnableFeignClients(basePackages = {"com.utina.core.display.client","com.utina.core.display.services"})
@EntityScan("com.utina.core")
@EnableJpaRepositories("com.utina.core")
@EnableDiscoveryClient
@EnableSwagger2

public class DisplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayApplication.class, args);
	}
	
	
	

}
