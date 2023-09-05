package com.mehedi.shop.controller;

import com.mehedi.shop.model.OrderEntity;
import com.mehedi.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/create_order")
	public ResponseEntity<?> create(@RequestBody OrderEntity orderEntity) {
		orderService.createOrder(orderEntity);
		return ResponseEntity.ok("order is created");
	}
	@GetMapping("/get/order")
	public ResponseEntity<?> get() {
		return ResponseEntity.ok(orderService.getAllOrder());
	}

	@GetMapping("/get/order/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id) {
		return ResponseEntity.ok(orderService.findOrderById(id));
	}

	@PutMapping("/update/order")
	public ResponseEntity<?> update(@RequestBody OrderEntity orderEntity) {
		orderService.updateOrder(orderEntity);
		return ResponseEntity.ok("order is updated successfully");
	}

	@DeleteMapping("/delete/order/{id}")
	public ResponseEntity<?> create(@PathVariable Integer id) {
		orderService.deleteOrder(id);
		return ResponseEntity.ok("order is deleted successfully");
	}

}
