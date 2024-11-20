package com.training.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/")
	public String home(Model model) {
		// page state
		model.addAttribute("pageTitle", "Home");
		model.addAttribute("menuHome", true);

		return "index";
	}

}
