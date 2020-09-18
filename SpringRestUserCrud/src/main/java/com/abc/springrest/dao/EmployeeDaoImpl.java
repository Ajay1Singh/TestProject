package com.abc.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.abc.springrest.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {

		List<Employee> employees = entityManager.createQuery("from Employee", Employee.class).getResultList();

		return employees;
	}

	@Override
	public Employee findById(int employeeId) {

		Employee employee = entityManager.find(Employee.class, employeeId);

		if (employee == null) {
			throw new RuntimeException("Object not found for the id:" + employeeId);
		} else {
			return employee;

		}

	}

	@Override
	public Employee save(Employee employee) {

		Employee dbEmployee = entityManager.merge(employee);

		employee.setId(dbEmployee.getId());
		return employee;
	}

	@Override
	public void deleteById(int employeeId) {

		entityManager.createQuery("delete from Employee where id=:employeeId").setParameter("employeeId", employeeId)
				.executeUpdate();

	}

}
