package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shop.model.Product;

@CrossOrigin(origins="*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByPrice(double price);
}
