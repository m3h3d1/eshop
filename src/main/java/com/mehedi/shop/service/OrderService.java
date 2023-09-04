package com.mehedi.shop.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehedi.shop.exception.ProductNotExistException;
import com.mehedi.shop.model.OrderEntity;
import com.mehedi.shop.repository.OrderRepository;
import com.mehedi.shop.repository.ProductRepository;

import com.mehedi.shop.model.Product;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	public void productsNotEmpty(OrderEntity orderEntity) {
		Iterator<Product> products = orderEntity.getProducts().iterator();
		while (products.hasNext()) {
			Product product = products.next();
			boolean p = productRepository.findById(product.getId()).isPresent();
			System.out.println(p);
			if (!p) {
				products.remove();
			}
		}
		if (orderEntity.getProducts().isEmpty()) {
			throw new ProductNotExistException("Select Products");
		}
	}

	public void createOrder(OrderEntity orderEntity) {
		productsNotEmpty(orderEntity);
		orderRepository.save(orderEntity);
	}

	public void updateOrder(OrderEntity orderEntity) {
		productsNotEmpty(orderEntity);
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
