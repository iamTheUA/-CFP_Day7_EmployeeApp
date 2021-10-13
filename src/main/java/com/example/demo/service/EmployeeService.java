package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.exceptions.CustomException;
import com.example.demo.repo.EmployeeRepo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	//private List<Employee> employeeList = new ArrayList<>();
	
	public Employee get(int id) {
		log.info("Printing by id");
		return employeeRepo.getById(id);
	}
	
	public List<Employee> getall(){
		log.info("Printing All data");
		return employeeRepo.findAll();
	}
	
	public Employee add(EmployeeDTO employeeDTO) {
		Employee employee= new Employee(employeeDTO);
		employeeRepo.save(employee);
		return employee;
	}
	
	public Employee update(int id, EmployeeDTO employeeDTO) {
		if(employeeRepo.existsById(id)) {
		Employee employee = new Employee(id, employeeDTO);
		employeeRepo.deleteById(id);
		employeeRepo.save(employee);
		return employee;}
		else {
			throw new CustomException("Doesn't exist");
		}
	}
	
	public  List<Employee> delete(int id) {
		if(employeeRepo.existsById(id)) {
		employeeRepo.deleteById(id);
		return employeeRepo.findAll();
		}
		else {
			throw new CustomException("Doesn't exist");
		}
	}
	
	public List<Employee> byDepartment(String department){
		return employeeRepo.findEmployeeByDepartment(department);
	}
}
