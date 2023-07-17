package com.springboot.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.bean.Student;

@Controller
public class UtilityController {

	@GetMapping(value = "/demo/utilities")
	private String utilities(Model model) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		File path = new ClassPathResource("/static/students.json").getFile();
		TypeReference<List<Student>> typeReference = new TypeReference<>() {};
		List<Student> students = mapper.readValue(path, typeReference);
		model.addAttribute("dssv",students);
		model.addAttribute("now",new Date());
		return "utilities";
	}
}
