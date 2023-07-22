package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.DAO.studentDAO;
import com.example.model.Student;
import com.example.model.StudentMap;



@Controller
public class StudentController {

	@Autowired
	studentDAO dao;

	@RequestMapping(value = "/student/index")
	private String index(Model model) {
		
		StudentMap map = dao.findAll();
		model.addAttribute("students", map);
		model.addAttribute("form", new Student());
		return "controller/index";
	}
	
	@GetMapping(value = "/student/edit/{key}")
	private String edit(Model model, @PathVariable("key") String key) {
		model.addAttribute("key",key);
		Student student = dao.findByKey(key);
		model.addAttribute("form",student);
		StudentMap map = dao.findAll();
		model.addAttribute("students", map);
		return "controller/index";
	}
	
	@PostMapping(value = "/student/create")
	private String create(Model model, Student student) {
		dao.create(student);
		return "redirect:/student/index";
	}
	
	@PostMapping(value = "/student/update/{key}")
	private String update(Model model,@PathVariable("key") String key, Student student) {
		dao.update(key,student);
		return "redirect:/student/index";
	}
	
	@RequestMapping(value = "/student/delete/{key}")
	private String delete(Model model,@PathVariable("key") String key) {
		dao.delete(key);
		return "redirect:/student/index";
	}
}
