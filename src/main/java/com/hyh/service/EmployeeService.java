package com.hyh.service;

import java.util.List;

import com.hyh.entity.Employee;

public interface EmployeeService {

	public Employee getEmployeeById(Integer id);
	
	public void deleteEmployee(Integer id);
	
	public void updateEmployee(Employee employee);
	
	public void addEmployee(Employee employee);
	
	public List<Employee> list();

	public List<Employee> getEmployeeByName(String name);
}
