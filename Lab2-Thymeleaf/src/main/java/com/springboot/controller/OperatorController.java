package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OperatorController {
	
	@GetMapping(value = "/demo/operator")
	private String demo(Model model) {
		model.addAttribute("x",5);
		model.addAttribute("y",7);
		return "demo/operator";
	}
	
	
}
