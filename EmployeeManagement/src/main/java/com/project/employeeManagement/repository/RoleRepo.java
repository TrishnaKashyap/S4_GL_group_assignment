package com.project.employeeManagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.employeeManagement.entity.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {

}
