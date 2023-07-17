package com.springboot.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private String name;
	private boolean gender = false;
	private Double marks = 0.0;
	private Contact contact;
	List<String> subjects;
}
