package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping(value = "/hello.th")
	private String hello(Model model) {
		model.addAttribute("message","FPT <b> Polytechic </b>");
		return "hello";
	}
}
