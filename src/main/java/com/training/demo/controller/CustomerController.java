package com.training.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.demo.entity.Customer;
import com.training.demo.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/customer-list")
	public String customerList(Model model, HttpServletRequest request) {

		// page state
		model.addAttribute("pageTitle", "Customer");
		model.addAttribute("menu1", true);
		model.addAttribute("menu11", true);

		List<Customer> customers = customerService.listUser();
		model.addAttribute("customers", customers);

		return "customer-list";
	}

	@RequestMapping("/customer-form")
	public String customerForm(@RequestParam(value = "id", required = false) Long id, Model model) {
		Customer customer = new Customer();
		if (id != null) {
			customer = customerService.getById(id);
		}

		model.addAttribute("pageTitle", "Customer");
		model.addAttribute("menu1", true);
		model.addAttribute("menu11", true);
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	@RequestMapping(value = "/customer-form-save", method = RequestMethod.POST)
	public String customerFormSave(@ModelAttribute(value = "customer") Customer customer, BindingResult bindingResult,
			Model model) {
		customerService.save(customer);
		return "redirect:/customer-list?success";
	}

	@RequestMapping(value = "/customer-delete")
	public String customerDelete(@RequestParam(value = "id", required = true) Long id) {
		customerService.delete(id);
		return "redirect:/customer-list?deleted";
	}

}
