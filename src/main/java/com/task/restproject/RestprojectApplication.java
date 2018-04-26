package com.task.restproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.task.restproject.model")
public class RestprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestprojectApplication.class, args);
	}
}
