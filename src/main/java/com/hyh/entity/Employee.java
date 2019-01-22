package com.hyh.entity;

import java.util.Date;

public class Employee {

	private Integer id;
	private String name;
	private String sex;
	private Float salary;
	private Date hiredate;
	
	public Employee() {
		
	}
	
	public Employee(Integer id, String name, String sex, Float salary, Date hiredate) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	
}
