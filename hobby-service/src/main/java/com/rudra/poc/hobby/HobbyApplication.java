package com.rudra.poc.hobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HobbyApplication {

	public static void main(String[] args) throws Exception {
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		SpringApplication.run(HobbyApplication.class, args);
	}
}
