package com.training.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.training.demo.entity.Customer;
import com.training.demo.repository.CustomerRepository;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {

			Customer pelanggan = new Customer();
			pelanggan.setFirstName("Rama");
			pelanggan.setLastName("Ambara");

			// insert into customer (firstName, lastName) values ('Rama', 'Ambara');
			repository.save(pelanggan);

			pelanggan = new Customer();
			pelanggan.setFirstName("Test");
			pelanggan.setLastName("123");

			// insert into customer (firstName, lastName) values ('Test', '123');
			repository.save(pelanggan);

			List<Customer> customers = repository.findByLastName("Ambara");
			for (Customer customer : customers) {
				System.out.println(customer.getFirstName());
				System.out.println(customer.getLastName());

			}

			// save a couple of customers
			repository.save(new Customer("Bruce", "Willis"));
			repository.save(new Customer("Tom", "Hanks"));
			repository.save(new Customer("Demi", "Moore"));
			repository.save(new Customer("Sandra", "Bullock"));
			repository.save(new Customer("Jim", "Carey"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer cust = repository.findById(1L);
			if (cust != null) {
				log.info("Customer found with findById(1L):");
				log.info("--------------------------------");
				log.info(cust.toString());
				log.info("");
			}
			;

			// fetch customers by last name
			log.info("Customer found with findByLastName('Hanks'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Hanks").forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");
		};
	}
}
