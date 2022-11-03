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
import com.project.employeeManagement.entity.Employee;
import com.project.employeeManagement.service.EmployeeService;

@Controller
@RequestMapping("/directory")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/employees")
	public String getAllEmployees(Map<String, List<Employee>> map) {
		List<Employee> emp = service.findAll();
		map.put("Employees", emp);
		return "employees";
	}

	@RequestMapping("/add-employee")
	public String showFormForAdd(Model theModel) {
		Employee emp = new Employee();
		theModel.addAttribute("Employee", emp);
		return "addNewEmployee";
	}

	@RequestMapping("/edit-employee")
	public String showFormForUpdate(@RequestParam("id") int id, Model theModel) {

		Employee emp = service.findById(id);
		theModel.addAttribute("Employee", emp);
		return "addNewEmployee";
	}

	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id, @RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
			@RequestParam("email") String email, @RequestParam("phone") String phone,
			@RequestParam("department") String department, @RequestParam("dob") String dob,
			@RequestParam("doj") String doj) {

		System.out.println(id);
		Employee emp;
		if (id != 0) {
			emp = service.findById(id);
			emp.setFirstName(firstName);
			emp.setLastName(lastName);
			emp.setEmail(email);
			emp.setPhone(phone);
			emp.setDepartment(department);
			emp.setDob(dob);
			emp.setDoj(doj);
		} else
			emp = new Employee(firstName, lastName, email, phone, department, dob, doj);
		service.save(emp);

		return "redirect:/directory/employees";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {

		service.deleteById(id);

		return "redirect:/directory/employees";

	}

	@GetMapping("/search")
	public String search(@RequestParam("firstName") String firstName, Model model) {

		if (firstName.trim().isEmpty()) {
			return "redirect:/directory/employees";
		} else {
			List<Employee> emp = service.findEmpByFirstName(firstName);

			model.addAttribute("Employees", emp);

			return "employees";
		}

	}
}
