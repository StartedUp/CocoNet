package com.coconet.mit.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.coconet.mit.admin", "com.coconet.mit.appService"})
@EnableAutoConfiguration
@ComponentScan
@EntityScan("com.coconet.mit.commons.model")
public class MitAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(MitAdminApplication.class, args);
	}
}
