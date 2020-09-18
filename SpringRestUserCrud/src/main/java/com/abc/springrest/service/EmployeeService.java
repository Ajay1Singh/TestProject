package com.abc.springrest.service;

import java.util.List;

import com.abc.springrest.model.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int employeeId);

	public Employee save(Employee employee);

	public void deleteById(int employeeId);


}
