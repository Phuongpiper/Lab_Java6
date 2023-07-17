package com.springboot.controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ScopeController {
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext context;
	
	
	@RequestMapping(value = "/scope")
	private String index(Model model) {
		model.addAttribute("a","I am in model");
		request.setAttribute("b", "I am in Request scope");
		session.setAttribute("c", "I am Session scope");
		context.setAttribute("d", "I am in Application scope");
		return "scope/index";
	}
}
