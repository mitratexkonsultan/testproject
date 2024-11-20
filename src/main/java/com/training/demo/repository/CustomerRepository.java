package com.training.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.training.demo.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	// select * from customer where lastName=''
	List<Customer> findByLastName(String lastName);

	// select * from customer where fistName='' and lastName=''
	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

	Customer findById(Long id);
}