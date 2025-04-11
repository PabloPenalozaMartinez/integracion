package com.integracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:conf.properties")
@SpringBootApplication
public class IntegracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegracionApplication.class, args);
	}

}
