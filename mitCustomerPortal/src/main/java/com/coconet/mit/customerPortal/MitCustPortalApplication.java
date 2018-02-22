package com.coconet.mit.customerPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.coconet.mit.customerPortal", "com.coconet.mit.appService", "com.coconet.mit.dbService"})
@EnableJpaRepositories("com.coconet.mit.dbService")
@EntityScan("com.coconet.mit.commons")
/*@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.coconet"})*/
public class MitCustPortalApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MitCustPortalApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MitCustPortalApplication.class, args);
	}
}
