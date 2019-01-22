package com.hyh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.Cacheable;

import com.hyh.entity.Employee;

@Mapper
public interface EmployeeMapper {

	@Select("select * from employee where id=#{id}")
	public Employee getEmployeeById(Integer id);
	
	@Select("select * from employee where name=#{name} ")
	public List<Employee> getEmployeeByName(String name);
	
	@Delete("delete from employee where id=#{id}")
	public void deleteEmployee(Integer id);
	
	@Update("update employee set name=#{name},sex=#{sex},salary=#{salary},hiredate=#{hiredate} where id=#{id}")
	public void updateEmployee(Employee employee);
	
	@Insert("insert into employee (name,sex,salary,hiredate) values(#{name},#{sex},#{salary},#{hiredate})")
	public void addEmployee(Employee employee);
	
	@Select("select * from employee")
	public List<Employee> list();
}
