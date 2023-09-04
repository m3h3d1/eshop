package com.mehedi.shop.controller;

import com.mehedi.shop.model.Customer;
import com.mehedi.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/create_customer")
	public ResponseEntity<?> create(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		return ResponseEntity.ok("customer is created");
	}

	@PutMapping("/update/customer")
	public ResponseEntity<?> update(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
		return ResponseEntity.ok("customer is updated");
	}

	@DeleteMapping("/delete/customer/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		customerService.deleteCustomer(id);
		return ResponseEntity.ok("customer is removed");
	}

	@GetMapping("/get/customer")
	public ResponseEntity<?> get() {
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping("/get/customer/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id) {
		return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK);
	}
}
