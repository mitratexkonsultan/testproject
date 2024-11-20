package com.training.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.demo.entity.Customer;
import com.training.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getById(Long id) {
		return customerRepository.findById(id);
	}

	public void delete(Long id) {
		customerRepository.delete(id);
	}

	public List<Customer> listUser() {
		return (List<Customer>) customerRepository.findAll();
	}

}
