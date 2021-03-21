package com.cg.onlinepizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication

//@EntityScan(basePackages = "com.cg.onlinepizza.entities")
public class Sprint1OnlinePizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprint1OnlinePizzaApplication.class, args);
	}

}
