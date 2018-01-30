package com.shop.resource;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shop.model.Product;

@Component
public class ProductResourceAssembler {

	public Collection<ProductResource> toResourceCollection(Collection<Product> domainObjects) {
		return domainObjects.stream().map(o -> toResource(o)).collect(Collectors.toList());
	}

	public ProductResource toResource(Product o) {
		ProductResource resource = new ProductResource();
		resource.setProduct(o);
		return resource;
	}

}
