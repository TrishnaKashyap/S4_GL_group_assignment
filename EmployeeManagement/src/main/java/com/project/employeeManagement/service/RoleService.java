package com.project.employeeManagement.service;

import java.util.List;

import com.project.employeeManagement.entity.Role;

public interface RoleService {
	public List<Role> findAll();

	public void save(Role role);
	
	public Role findById(int theId);
}
