package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;

@RestController
public class DemoController {

	private Employee emp;

	@GetMapping("/")
	public String greeting() {
		return "Hello Ford";
	}

	// R
	@GetMapping("employee")
	public Employee getEmployee() {
		return this.emp;
	}

	// C
	@PostMapping("employee")
	public String addEmployee(@RequestBody Employee newEmployee) {
		emp = newEmployee;
		System.out.println(newEmployee);
		return "Employee added";
	}

	//U
	@PutMapping("employee")
	public String updateEmployee(@RequestBody Employee updateEmployee) {
		emp = updateEmployee;
		System.out.println(updateEmployee);
		return "Employee Updated";
	}

	//D
	@DeleteMapping("employee")
	public String deleteEmployee() {
		this.emp = null;
		return "Employee Delete";
	}
	//Partial update of resource
	@PatchMapping("employee/name/{name}")
	public String updateEmployeeName(@PathVariable("name") String newName) {
		
		emp.setName(newName);
		return "Employee name updated";
	}

}
