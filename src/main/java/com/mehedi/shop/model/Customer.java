package com.mehedi.shop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Component
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	private String address;
	private String name;

	@OneToMany(mappedBy = "customer")
	private List<OrderEntity> orderEntity = new ArrayList<>();

	public Customer() {
		super();
	}


	public Customer(Integer id, String name, String address, List<OrderEntity> orderEntity) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.orderEntity = orderEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<OrderEntity> getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(List<OrderEntity> orderEntity) {
		this.orderEntity = orderEntity;
	}

}
