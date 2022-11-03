package com.project.employeeManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.employeeManagement.entity.MyUserDetails;
import com.project.employeeManagement.entity.User;
import com.project.employeeManagement.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;

	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("user not found");
		return new MyUserDetails(user);
	}

}
