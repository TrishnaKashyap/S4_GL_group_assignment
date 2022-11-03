package com.project.employeeManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.employeeManagement.entity.Role;
import com.project.employeeManagement.service.RoleService;

@Controller
@RequestMapping("/api/role")
public class AuthorizationController {
	
	@Autowired
	RoleService service;
	
	@GetMapping("/fetchAllRoles")
	public String fetchAllRoles(Map<String, List<Role>> map){
		List<Role> roles = service.findAll();
		map.put("Roles", roles);
		return "roleList";
	}
	
	@RequestMapping("/addRole")
	public String addRole(Model model) {
		Role role = new Role();
		model.addAttribute("Role", role);
		return "addNewRole";
	}
	
	@PostMapping("/save")
	public String saveRole(@RequestParam("name") String name) {
		Role role = new Role(name);
		service.save(role);
		return "redirect:/api/role/fetchAllRoles";
	}
}
