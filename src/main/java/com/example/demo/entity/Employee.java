package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.example.demo.dto.EmployeeDTO;

import lombok.Data;

@Entity
@Data
@Table(name="employee_data")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;	
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	@ElementCollection
	@CollectionTable(name="employee_department", joinColumns = @JoinColumn(name="id"))
	@Column(name="department")
	private List<String> departments;
	
	public Employee(int id, EmployeeDTO employeeDTO) {
		this.id=id;
		this.name=employeeDTO.name;
		this.salary=employeeDTO.salary;
		this.startDate=employeeDTO.startDate;
		this.note=employeeDTO.note;
		this.profilePic=employeeDTO.profilePic;
		this.gender=employeeDTO.gender;
		this.departments=employeeDTO.departments;
		
	}
	
	public Employee(EmployeeDTO employeeDTO) {
		this.id=id;
		this.name=employeeDTO.name;
		this.salary=employeeDTO.salary;
		this.startDate=employeeDTO.startDate;
		this.note=employeeDTO.note;
		this.profilePic=employeeDTO.profilePic;
		this.gender=employeeDTO.gender;
		this.departments=employeeDTO.departments;
		
	}
		
}
