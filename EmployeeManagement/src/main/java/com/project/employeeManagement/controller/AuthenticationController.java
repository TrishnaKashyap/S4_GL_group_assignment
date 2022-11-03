package com.project.employeeManagement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.employeeManagement.entity.Role;
import com.project.employeeManagement.entity.User;
import com.project.employeeManagement.service.RoleService;
import com.project.employeeManagement.service.UserService;

@Controller
@RequestMapping("/api/user")
public class AuthenticationController {

	@Autowired
	private UserService service;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private RoleService roleService;

	@GetMapping("/fetchAllUsers")
	public String fetchAllUsers(Map<String, List<User>> map) {
		List<User> users = service.findAll();
		map.put("Users", users);
		return "userList";
	}

	@RequestMapping("/addUser")
	public String showFormForAdd(Model theModel, Map<String, List<Role>> map) {
		User user = new User();
		theModel.addAttribute("User", user);
		List<Role> roles = roleService.findAll();
		map.put("Roles", roles);
		return "addNewUser";
	}

	@RequestMapping("/edit")
	public String showFormForUpdate(@RequestParam("id") Long id, Model theModel, Map<String, List<Role>> map) {

		User user = service.findById(id);
		theModel.addAttribute("User", user);
		List<Role> roles = roleService.findAll();
		map.put("Roles", roles);
		return "addNewUser";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("user")User userData, 
		      BindingResult result, ModelMap model) {
//		@RequestParam("id") Long id, @RequestParam("username") String username,
//		@RequestParam("password") String password, @RequestParam("roles") Set<Role> role
		
		if (result.hasErrors()) {
            return "error";
        }
		User user;
		System.out.println("User data is ->>>> "  + userData +  " result -> " +result);
		if (userData.getId() != null) {
			user = service.findById(userData.getId());
			user.setUsername(userData.getUsername());
			user.setRoles(userData.getRoles());
		} else
			user = new User(userData.getUsername(), encoder.encode(userData.getPassword()), userData.getRoles());
		service.save(user);
		return "redirect:/api/user/fetchAllUsers";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") long id) {
		service.deleteById(id);
		return "redirect:/api/user/fetchAllUsers";

	}

	@GetMapping("/search")
	public String search(@RequestParam("username") String username, Model model) {

		if (username.trim().isEmpty()) {
			return "redirect:/api/user/fetchAllUsers";
		} else {
			User user = service.findByUsername(username);
			model.addAttribute("User", user);
			return "SearchUser";
		}
	}
}
