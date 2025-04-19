package com.fastmarket.fastmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.fastmarket.fastmarket.model")
@ComponentScan(basePackages = "com.fastmarket.fastmarket")
@EnableJpaRepositories(basePackages = "com.fastmarket.fastmarket.repositories")
@EnableTransactionManagement
public class FastmarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastmarketApplication.class, args);
	}

}
