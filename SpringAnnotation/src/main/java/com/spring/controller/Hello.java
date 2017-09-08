package com.spring.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Employee;

@RestController
public class Hello {

	@RequestMapping(value="/greeting")
	public List<Employee> sayhello(Model model) {
		List<Employee> lol=new ArrayList<Employee>();
		Employee emp=new Employee();
		emp.setAge(21);
		emp.setName("AShwani");
		lol.add(emp);
	return lol;	
	}
}
