package com.shop.resource;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "products")
public class ProductResourceList {

	@JsonProperty("products")
	private Collection<ProductResource> list;

	public Collection<ProductResource> getList() {
		return list;
	}

	@XmlElement(name = "product")
	public void setList(Collection<ProductResource> list) {
		this.list = list;
	}
	
}
