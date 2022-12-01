package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins ="http://localhost:4200")
public class DemoController {

	private Map<Integer,Employee> empMap=new HashMap<>();
	

	@GetMapping("employees")
	public Collection<Employee> getAllEmployees() {
//		List<Employee> empList = new ArrayList<>();
//		empList.add(new Employee(1,"name 1",100.0));
//		empList.add(new Employee(4,"name 4",400.0));
//		empList.add(new Employee(2,"name 2",200.0));
		return empMap.values();
	}
	@GetMapping("/")
	@CrossOrigin(origins ="http://localhost:4200")
	public String greeting() {
		return "Hello Ford";
	}

	// R
	@GetMapping("employee/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		return this.empMap.get(id);
	}

	// C
	@PostMapping("employee")
	public String addEmployee(@RequestBody Employee newEmployee) {
		
		this.empMap.put(newEmployee.getId(),newEmployee);
		return "Employee added";
	}

	//U
	@PutMapping("employee")
	public String updateEmployee(@RequestBody Employee updateEmployee) {
		
		this.empMap.replace(updateEmployee.getId(),updateEmployee);
		return "Employee Updated";
	}

	//D
	@DeleteMapping("employee/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		this.empMap.remove(id);
		return "Employee Deleted by id="+id;
	}
	//Partial update of resource
	@PatchMapping("employee/name/{id}/{name}")
	public String updateEmployeeName(@PathVariable("id") Integer id, @PathVariable("name") String newName) {
		
		this.empMap.get(id).setName(newName);
		return "Employee name updated";
	}

}
