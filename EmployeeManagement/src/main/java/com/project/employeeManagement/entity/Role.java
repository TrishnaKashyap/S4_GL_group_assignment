package com.project.employeeManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	public Role(String name) {
		super();
		this.name = name;
	}
	public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Role(Integer id) {
        this.id = id;
    }
}
