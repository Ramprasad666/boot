package com.jsp.bootdemowithdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication (scanBasePackages="com.jsp")// it is used to specify the Rest controller classes whenever we created outside the parent package to the restapi
@EnableJpaRepositories (basePackages = "com.jsp.bootdemowithdatabase.repository"  )   // specify the package name of  repositories to springboot
@EntityScan(basePackages = "com.jsp.bootdemowithdatabase.dto")  //specify the location (package name) of our entity classes to spring boot

public class BootdemowithdatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootdemowithdatabaseApplication.class, args);
	}

}
