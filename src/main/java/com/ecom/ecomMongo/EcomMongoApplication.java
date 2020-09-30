package com.ecom.ecomMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ecom")
public class EcomMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomMongoApplication.class, args);
	}

}
