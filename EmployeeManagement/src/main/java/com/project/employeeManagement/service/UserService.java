package com.project.employeeManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.employeeManagement.entity.User;

@Service
public interface UserService {
	
	public List<User> findAll();

	public void save(User user);
	
	public User findById(Long id);
	
	public void deleteById(Long id);

	public User findByUsername(String username);

}
