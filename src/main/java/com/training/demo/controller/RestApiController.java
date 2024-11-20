package com.training.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.training.demo.service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
public class RestApiController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/api/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String apiCustomer() {
		String result = new Gson().toJson(customerService.listUser());
		return result;
	}
}
