package com.mehedi.shop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@Component
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String productName;
	private Integer price;
	private Integer quantity;

	@ManyToMany(mappedBy = "products")
	private List<OrderEntity> orderEntites = new ArrayList<>();

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String productName, Integer price, Integer quantity, List<OrderEntity> orderEntites) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.orderEntites = orderEntites;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<OrderEntity> getOrderEntites() {
		return orderEntites;
	}

	public void setOrderEntites(List<OrderEntity> orderEntites) {
		this.orderEntites = orderEntites;
	}

}
