package com.shop.resource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.shop.model.Product;

@Component
public class ProductResourceAssembler {

	public ProductResourceList toResourceCollection(Collection<Product> domainObjects) {
		ProductResourceList list = new ProductResourceList();
		list.setList(domainObjects.stream().map(o -> toResource(o)).collect(Collectors.toList()));
		return list;
	}

	public ProductResource toResource(Product o) {
		return new ProductResource(o);
	}

}
