package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;

@Component
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query(value = "select * from employee_data, employee_department where id = id and department = :department", nativeQuery = true)
	List<Employee> findEmployeeByDepartment(String department);

}
