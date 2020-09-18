package com.abc.springrest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springrest.model.Employee;
import com.abc.springrest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		return employeeService.findById(employeeId);
	}

	@PostMapping("/employees")
	public Employee save(@RequestBody Employee employee) {
		employee.setId(0);
		return employeeService.save(employee);
	}

	@PutMapping("/employees")
	public Employee update(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteById(@PathVariable int employeeId) {

		Employee employee = employeeService.findById(employeeId);

		if (employee == null) {

			throw new RuntimeException("Record not found for the id :" + employeeId);
		} else {
			employeeService.deleteById(employeeId);

			return "Object got deleted for the id :" + employeeId;

		}

	}

}
