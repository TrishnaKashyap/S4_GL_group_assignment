package com.project.employeeManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Sort;
import com.project.employeeManagement.entity.Employee;
import com.project.employeeManagement.repository.EmployeeRepo;
import com.project.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo repo;
	
	@Override
	public List<Employee> findAll() {
		return repo.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}

	@Override
	public Employee findById(int theId) {
		return repo.findById(theId).get();
	}

	@Override
	public void save(Employee emp) {
		repo.save(emp);
		
	}

	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
	}

	@Override
	public List<Employee> findEmpByFirstName(String firstname) {
		return repo.findEmpByFirstName(firstname);
	}
}
