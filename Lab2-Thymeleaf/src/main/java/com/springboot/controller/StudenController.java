package com.springboot.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.bean.Student;

@Controller
public class StudenController {
	@GetMapping(value = "/student")
	private String index(Model model, @RequestParam(value = "index")Optional<Integer> index) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		File path = ResourceUtils.getFile("Lab2-Thymeleaf/src/main/resources/static/students.json");
		TypeReference<List<Student>> typeReference = new TypeReference<>() {};
		List<Student> students = mapper.readValue(path, typeReference);
		int i = index.orElse(0);
		model.addAttribute("index", i);
		model.addAttribute("student",students.get(i));
		
		return "scope/student";
	}
}
