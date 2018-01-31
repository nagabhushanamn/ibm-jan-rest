package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Product;
import com.shop.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	List<Review> findByProduct(Product product);

}
