package com.example.demo.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;


@ToString public class EmployeeDTO {

	@Pattern(regexp = "^[A-Z][a-z]{2,}$", message= "Invalid Name!")
	public String name;
	
	@Min(value = 500, message="Min Value is 500")
	public int salary;
	
	@Pattern(regexp = "M|F", message = "Gender must be 'M' or 'F'")
	public String gender;
	
	@JsonFormat(pattern="dd MMM yyyy")
	@NotNull(message = "startDate is Empty")
	@PastOrPresent(message = "startDate can be in Future!")
	public LocalDate startDate;
	
	@NotNull(message = "profilePic is Empty")
	public String profilePic;
	
	@NotNull(message = "note is Empty")
	public String note;
	
	@NotNull(message = "departments is Empty")
	public List<String> departments;

}
