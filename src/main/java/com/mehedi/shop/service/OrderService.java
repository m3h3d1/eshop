package com.mehedi.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehedi.shop.exceptionHandler.ProductNotExistException;
import com.mehedi.shop.model.OrderEntity;
import com.mehedi.shop.repository.OrderRepository;
import com.mehedi.shop.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;


	public void createOrder(OrderEntity orderEntity) {
		orderRepository.save(orderEntity);
	}

	public void updateOrder(OrderEntity orderEntity) {
		orderRepository.save(orderEntity);
	}

	public void deleteOrder(Integer id) {
		if (orderRepository.findById(id).isEmpty()) {
			throw new ProductNotExistException("Order not exists");
		}
		orderRepository.deleteById(id);
	}

	public List<OrderEntity> getAllOrder() {
		return orderRepository.findAll();
	}

	public OrderEntity findOrderById(Integer id) {
		Optional<OrderEntity> orderEntity = orderRepository.findById(id);
		if (orderEntity.isEmpty()) {
			throw new ProductNotExistException("Order not exists");
		}
		return orderEntity.get();
	}
}
