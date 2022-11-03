package com.project.employeeManagement.service;

import java.util.List;

import com.project.employeeManagement.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee emp);

	public void deleteById(int theId);

	public List<Employee> findEmpByFirstName(String fullName);
}