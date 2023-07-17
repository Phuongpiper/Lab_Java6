package com.springboot.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.bean.Student;

@Controller
public class HomeController {
	@GetMapping(value = "/home/index")
	private String home(Model model) throws StreamReadException, DatabindException, IOException {
		model.addAttribute("message", "Welcome to Thymeleaf");
		
		ObjectMapper mapper = new ObjectMapper();
		String path = "Lab2-Thymeleaf/src/main/resources/static/student.json";
		Student student = mapper.readValue(new File(path), Student.class);
		model.addAttribute("sv",student);
		
		return "home/index";
	}
}
