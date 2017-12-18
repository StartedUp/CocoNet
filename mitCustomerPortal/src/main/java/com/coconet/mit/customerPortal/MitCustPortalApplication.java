package com.coconet.mit.customerPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
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
