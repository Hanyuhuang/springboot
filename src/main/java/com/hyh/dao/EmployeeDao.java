package com.hyh.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.hyh.entity.Employee;

public class EmployeeDao {
	
	static Map<Integer,Employee> map;
	
	static {
	    map = new HashMap<Integer,Employee>();
		Employee employee1 = new Employee(001,"张三","男",5900.00f,Date.valueOf("1998-7-9"));
		Employee employee2 = new Employee(002,"李四","男",6200.00f,Date.valueOf("2002-8-22"));
		Employee employee3 = new Employee(003,"王五","男",4300.00f,Date.valueOf("1999-9-11"));
		Employee employee4 = new Employee(004,"测试","男",3000.00f,Date.valueOf("2010-11-9"));
		Employee employee5 = new Employee(005,"测试","男",3000.00f,Date.valueOf("2011-7-11"));
		map.put(employee1.getId(), employee1);
		map.put(employee2.getId(), employee2);
		map.put(employee3.getId(), employee3);
		map.put(employee4.getId(), employee4);
		map.put(employee5.getId(), employee5);		
	}
	
	public void addEmployee(Employee employee) {
		map.put(employee.getId(),employee);
	}
	
	public void deleteEmployee(Integer id) {
		map.remove(id);
	}
	
	public Employee getEmployee(Integer id) {
		return map.get(id);
	}
	
	public void updateEmployee(Employee employee) {
		map.replace(employee.getId(),employee);
	}
	
	public List<Employee> list() {
		List<Employee> list = new ArrayList<Employee>();
		for(int key:map.keySet()) {
			list.add(map.get(key));
		}
		return list;
	}
}
