package com.mehedi.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehedi.shop.exception.ProductNotExistException;
import com.mehedi.shop.model.Product;
import com.mehedi.shop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public void createProduct(Product product) {
		productRepository.save(product);
	}

	public void updateProduct(Product product) {
		productRepository.save(product);
	}

	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product findProductById(Integer id) {
		Optional<Product> productById = productRepository.findById(id);
		Product product = null;
		if (!productById.isPresent()) {
			throw new ProductNotExistException("product doesn't exist");
		}
		return product;
	}
}
