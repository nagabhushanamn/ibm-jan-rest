package com.shop;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shop.model.Review;
import com.shop.repository.ProductRepository;
import com.shop.repository.ReviewRepository;


@SpringBootApplication
public class ShopApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApiServerApplication.class, args);
	}

//	
//	@Bean
//	public CommandLineRunner cli(ProductRepository productRepository, ReviewRepository reviewRepository) {
//		return args -> {
//
//			// List<Product> products = productRepository.findAll();
//			// products.forEach(p -> System.out.println(p));
//
//			// List<Review> reviews =
//			// reviewRepository.findByProduct(productRepository.findOne(1));
//			// reviews.forEach(r -> System.out.println(r));
//
//		};
//	}
}
