package com.hyh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hyh.dao.EmployeeDao;
import com.hyh.entity.Employee;
import com.hyh.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	//EmployeeDao employeeDao;
	EmployeeService employeeService;
	
	@GetMapping("/list")
	public String list(Model model,String name) {
		List<Employee> list = null;
		if(name!=null&&!"".equals(name)) {
			list = employeeService.getEmployeeByName(name);
		}else {
			list = employeeService.list();	
		}
		model.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping("/id")
	public String id(Model model,Integer id) {
		Employee list = employeeService.getEmployeeById(id);
		model.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping("/goAddPage")
	public String goAddPage() {
		return "add";
	}
	
	@PostMapping("/add")
	public String add(Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/goUpdatePage/{id}")
	public String goUpdatePage(@PathVariable("id")Integer id,Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("emp", employee);
		return "update";
	}
	
	@PostMapping("/update")
	public String update(Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Integer id) {
		employeeService.deleteEmployee(id);
		return "redirect:/list";
	}
}
