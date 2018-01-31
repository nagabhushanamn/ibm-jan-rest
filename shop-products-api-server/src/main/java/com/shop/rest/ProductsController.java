package com.shop.rest;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Product;
import com.shop.model.Review;
import com.shop.repository.ProductRepository;
import com.shop.repository.ReviewRepository;
import com.shop.resource.ProductResource;
import com.shop.resource.ProductResourceAssembler;
import com.shop.resource.ProductResourceList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@Api(tags= {"Product"}, description="everything about product resource")
@RestController
@RequestMapping(
		value = "/api/products"
		//produces = { "application/json"},
		//consumes = {"application/json"}
		)
public class ProductsController {
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ProductResourceAssembler assembler;


	@ApiOperation(value = "View a list of available products", response = ProductResourceList.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(produces= {"application/json","application/xml"})
	public ResponseEntity<ProductResourceList> findAll() {
		System.out.println("loading all products..");
		List<Product> products = productRepository.findAll();
		return new ResponseEntity<ProductResourceList>(assembler.toResourceCollection(products), HttpStatus.OK);
	}

	@GetMapping(value = "{id}",produces= {"application/json","application/xml"})
	public ResponseEntity<ProductResource> find(@PathVariable int id) {
		Product product = productRepository.findOne(id);
		return new ResponseEntity<ProductResource>(assembler.toResource(product), HttpStatus.OK);
	}
	
	@PostMapping(value = "/{prodId}/reviews")
	public ResponseEntity<Review> addNewReview(@PathVariable int prodId, @RequestBody Review review) {
		Product product = productRepository.findOne(prodId);
		review.setProduct(product);
		Review savedReview = reviewRepository.save(review);
		return new ResponseEntity<Review>(savedReview, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/{prodId}/reviews")
	public ResponseEntity<List<Review>> findOneReview(@PathVariable int prodId,Principal principal) {
		Product product = productRepository.findOne(prodId);
		System.out.println("Current User : "+principal.getName());
		List<Review> reviews = reviewRepository.findByProduct(product);
		return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
	}

	@GetMapping(value = "/{prodId}/reviews/{reviewId}")
	public ResponseEntity<Review> findOneReview(@PathVariable int prodId, @PathVariable int reviewId) {
		Review review = reviewRepository.findOne(reviewId);
		if(review==null) {
			throw new ReviewNotFoundException("Review Not Exist with Us");
		}
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
//	
//	@ExceptionHandler(value = { RuntimeException.class })
//	public ResponseEntity<String> haneleAnyException(Throwable e) {
//		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
//	}
//	
	

}
