package com.basecs101.restapp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com")
public class SpringBootRestApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApp.class, args);
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	String beanObject(){
		return "beanObjectCreated";
	}
}
