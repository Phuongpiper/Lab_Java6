package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuiController {
	
	@GetMapping(value = "home/index")
	private String home() {
		return "home/index";
	}
	
	@GetMapping(value = "home/about")
	private String about() {
		return "home/about";
	}
}
