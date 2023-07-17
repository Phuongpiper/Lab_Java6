package com.springboot.controller;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonMain {
	public static void main(String[] args) throws IOException {
		demo1();
		System.out.println("-------------------------");
		demo2();
	}

	private static void demo2() throws IOException {
		String json = "Lab1-StreamAPI-JackJsonAPI/src/main/resources/static/students.json";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode students = mapper.readTree(new File(json));
		students.iterator().forEachRemaining(student ->{
			System.out.println("name : " + student.get("name").asText());
		});
	}

	private static void demo1() throws IOException {
		String json = "Lab1-StreamAPI-JackJsonAPI/src/main/resources/static/student.json";
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode student = mapper.readTree(new File(json));
		System.out.println(student.get("name").asText());
		System.out.println(student.get("marks").asDouble());
		System.out.println(student.get("gender").asBoolean());
		System.out.println(student.get("contact").get("email").asText());
		System.out.println(student.findValue("phone").asText());
		student.get("subjects").iterator().forEachRemaining(Subject -> {
			System.out.println(Subject.asText());
		});
	}
}
