package com.project.CollegeFest.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.CollegeFest.Entity.MyUserDetails;
import com.project.CollegeFest.Entity.User;
import com.project.CollegeFest.Repo.UserRepo;

public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User not found");
		return new MyUserDetails(user);
	}
}
