package com.shop.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.shop.model.Product;

@XmlRootElement
public class ProductResource {

	@JsonUnwrapped // jackson annotation
	private Product product;

	public ProductResource() {
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

}
