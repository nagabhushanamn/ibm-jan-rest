package com.shop.resource;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import com.shop.model.Product;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "product")
public class ProductResource{

	@ApiModelProperty(notes = "The database generated product ID")
	private int id;
	private String name;
	@ApiModelProperty(notes = "The product price..")
	private double price;
	private String image_path;
	private Date make_date;
	private String description;

	public ProductResource() {
	}

	public ProductResource(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.image_path = product.getImage_path();
		this.make_date = product.getMake_date();
		this.description = product.getDescription();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public Date getMake_date() {
		return make_date;
	}

	public String getDescription() {
		return description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setMake_date(Date make_date) {
		this.make_date = make_date;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

}
