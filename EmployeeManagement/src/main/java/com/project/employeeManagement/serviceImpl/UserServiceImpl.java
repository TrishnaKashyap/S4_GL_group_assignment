package com.project.employeeManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeeManagement.entity.User;
import com.project.employeeManagement.repository.UserRepo;
import com.project.employeeManagement.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo repo;
	
	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public void save(User user) {
		repo.save(user);
	}

	@Override
	public User findById(Long id) {
		return this.repo.findById(id).get();
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

	@Override
	public User findByUsername(String username) {
		return repo.findByUsername(username);
	}
	

}
