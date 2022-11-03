package com.project.employeeManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeeManagement.entity.Role;
import com.project.employeeManagement.repository.RoleRepo;
import com.project.employeeManagement.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepo repo;

	@Override
	public List<Role> findAll() {
		return (List<Role>) repo.findAll();
	}

	@Override
	public void save(Role role) {
		repo.save(role);
	}

	@Override
	public Role findById(int theId) {
		return repo.findById(theId).get();
	}
}
