package com.hyh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.hyh.entity.Employee;
import com.hyh.mapper.EmployeeMapper;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper empoyeeMapper;
	
	@Override
	@Cacheable(value="employee",key="#id")
	public Employee getEmployeeById(Integer id) {
		return empoyeeMapper.getEmployeeById(id);
	}
	
	@Override
	@Cacheable
	public List<Employee> getEmployeeByName(String name) {
		return empoyeeMapper.getEmployeeByName(name);
	}

	@Override
	@CacheEvict(value="employee",key="#id")
	public void deleteEmployee(Integer id) {
		empoyeeMapper.deleteEmployee(id);
	}

	@Override
	@CachePut(value="employee",key="#result.id")
	public void updateEmployee(Employee employee) {
	    empoyeeMapper.updateEmployee(employee);
	}

	@Override
	public void addEmployee(Employee employee) {
		empoyeeMapper.addEmployee(employee);
	}

	@Override
	public List<Employee> list() {
		return empoyeeMapper.list();
	}

}
