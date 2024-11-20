package com.training.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

	public String getCurrency() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://open.er-api.com/v6/latest/USD";
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		return response.getBody();
	}

}
