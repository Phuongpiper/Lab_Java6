package com.springboot.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.bean.Student;

@Controller
@RequestMapping(value = "/student")
public class Student2Controller {

	@GetMapping("/list")
	private String list(Model model, @RequestParam(value = "index")Optional<Integer> index) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		File path = new ClassPathResource("/static/students.json").getFile();
		TypeReference<List<Student>> typeReference = new TypeReference<>() {};
		List<Student> students = mapper.readValue(path, typeReference);
		
		
		model.addAttribute("sv", students.get(index.orElse(0)));
		model.addAttribute("students",students);
		
		return "student/list";
	}
}
