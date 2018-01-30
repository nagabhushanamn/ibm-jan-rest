package com.shop;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;

@EnableJpaRepositories
@SpringBootApplication
public class ProductsServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsServiceAppApplication.class, args);
	}

}
