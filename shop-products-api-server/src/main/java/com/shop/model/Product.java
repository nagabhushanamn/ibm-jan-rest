package com.shop.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "PRODUCTS", schema = "shop_db")
public class Product {

	@Id
	private int id;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String name;
	private String image_path;
	private double price;
	@Temporal(TemporalType.DATE)
	private Date make_date;
	private String description;

//	@OneToMany(mappedBy = "product", targetEntity = Review.class)
//	private List<Review> reviews;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image_path=" + image_path + ", price=" + price
				+ ", make_date=" + make_date + ", description=" + description + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getMake_date() {
		return make_date;
	}

	public void setMake_date(Date make_date) {
		this.make_date = make_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<Review> getReviews() {
//		return reviews;
//	}
//
//	public void setReviews(List<Review> reviews) {
//		this.reviews = reviews;
//	}

}
