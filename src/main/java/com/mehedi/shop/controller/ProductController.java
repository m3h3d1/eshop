package com.mehedi.shop.controller;

import com.mehedi.shop.model.Product;
import com.mehedi.shop.service.ProductService;
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
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Product product) {
		productService.createProduct(product);
		return ResponseEntity.ok("product is created");
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody Product product) {
		productService.updateProduct(product);
		return ResponseEntity.ok("product is updated");
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return ResponseEntity.ok("product is removed");
	}

	@GetMapping("/get")
	public ResponseEntity<?> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> findProductById(@PathVariable Integer id) {
		return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
	}
}
