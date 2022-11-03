package com.project.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagement.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
