package com.shop.web;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import com.shop.resource.ProductResource;
import com.shop.resource.ProductResourceAssembler;

@RestController
@RequestMapping(value = "/api/products")
public class ProductRestController {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductResourceAssembler assembler;

	@PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json" })
	public ResponseEntity<ProductResource> create(@RequestBody Product product) {
		Product savedProduct = productRepository.save(product);
		return new ResponseEntity<ProductResource>(assembler.toResource(savedProduct), HttpStatus.CREATED);
	}

	@GetMapping(produces = { "application/json" })
	public ResponseEntity<Collection<ProductResource>> findAll() {
		List<Product> products = productRepository.findAll();
		return new ResponseEntity<Collection<ProductResource>>(assembler.toResourceCollection(products), HttpStatus.OK);
	}

	@GetMapping(value = "{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<ProductResource> find(@PathVariable int id) {
		Product product = productRepository.findOne(id);
		return new ResponseEntity<ProductResource>(assembler.toResource(product), HttpStatus.OK);
	}

}
