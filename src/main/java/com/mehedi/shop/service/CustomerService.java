package com.mehedi.shop.service;

import java.util.List;
import java.util.Optional;

import com.mehedi.shop.exceptionHandler.ProductNotExistException;
import com.mehedi.shop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehedi.shop.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void deleteCustomer(Integer id) {
		customerRepository.deleteById(id);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer findCustomerById(Integer id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (!customer.isPresent()) {
			throw new ProductNotExistException("Customer with ID " + id + " does not exist");
		}
		return customer.get();
	}
}
