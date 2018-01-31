package com.shop;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class ProductResource {

	private int id;
	private String name;
	private double price;
	private String image_path;
	private Date make_date;
	private String description;

	@Override
	public String toString() {
		return "ProductResource [id=" + id + ", name=" + name + ", price=" + price + ", image_path=" + image_path
				+ ", make_date=" + make_date + ", description=" + description + "]";
	}

	public ProductResource() {
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
