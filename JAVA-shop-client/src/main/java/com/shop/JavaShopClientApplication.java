package com.shop;

import org.springframework.web.client.RestTemplate;

public class JavaShopClientApplication {

	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://localhost:8080/api/products/1";

		// ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl,
		// String.class);
		// String body = response.getBody();
		// System.out.println(body);

		ProductResource productResource = restTemplate.getForObject(resourceUrl, ProductResource.class);
		System.out.println(productResource);

	}
}
