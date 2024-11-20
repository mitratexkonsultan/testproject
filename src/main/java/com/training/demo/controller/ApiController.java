package com.training.demo.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.demo.service.ApiService;

@Controller
public class ApiController {

	@Autowired
	ApiService apiService;

	@RequestMapping("/api-list")
	public String apiList(Model model, HttpServletRequest request) {

		// page state
		model.addAttribute("pageTitle", "API");
		model.addAttribute("menu2", true);
		model.addAttribute("menu21", true);

		JSONObject result = new JSONObject(apiService.getCurrency());
		JSONObject rates = result.getJSONObject("rates");

		System.out.println(rates);

		Map<String, Object> currencies = new HashMap<String, Object>();
		Iterator<String> keysItr = rates.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = rates.get(key);
			currencies.put(key, value);
		}

		model.addAttribute("currencies", currencies);

		return "api-list";
	}

}
