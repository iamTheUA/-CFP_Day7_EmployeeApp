package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeServ;
	
	/**
	 * will show EmployeeData with Given id;
	 * @param id
	 * @return ResponseEntity<ResponseDTO>
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getEmployeeData(@PathVariable int id) {
		Employee emp = employeeServ.get(id);
		ResponseDTO resposneDTO = new ResponseDTO("Data is:", emp);
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}

	/**
	 * Will show complete List of Employee
	 * @return ResponseEntity<ResponseDTO>
	 */
	@GetMapping("/")
	public ResponseEntity<ResponseDTO> getAllEmployeeData() {
		List<Employee> empList = employeeServ.getall();
		ResponseDTO resposneDTO = new ResponseDTO("Total List!", empList);
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}
	
	/**
	 * To add a EmployeeData to EmployeeList
	 * will take JSON of EmployeeDTO from body.
	 * @return ResponseEntity<ResponseDTO>
	 */
	@PostMapping(path="/add")
	public ResponseEntity<ResponseDTO> post( @Valid @RequestBody EmployeeDTO employeeDTO) {
		ResponseDTO resposneDTO = new ResponseDTO("Added successfully!", employeeServ.add(employeeDTO));
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}
 
	/**
	 * To Delete a EmployeeData from EmployeeList
	 * @param id
	 * @return ResponseEntity<ResponseDTO>
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> delete(@PathVariable int id) {
		ResponseDTO resposneDTO = new ResponseDTO("Deleted!", employeeServ.delete(id));
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}	

	/**
	 * To update Employee with given id
	 * @param id
	 * @param employeeDTO
	 * @return ResponseEntity<ResponseDTO>
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> update(@PathVariable("id") int id ,@RequestBody EmployeeDTO employeeDTO) {
		ResponseDTO resposneDTO = new ResponseDTO("Updated!", employeeServ.update(id, employeeDTO));
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}
	
	/**
	 * To print all Data by department.
	 * @param department 
	 * @return list of employee
	 */
	@GetMapping("/{department}")
	public ResponseEntity<ResponseDTO> getEmployeeDataByDepartment(@PathVariable String department) {
		ResponseDTO resposneDTO = new ResponseDTO("Data is:", employeeServ.byDepartment(department));
		return new ResponseEntity<ResponseDTO>(resposneDTO, HttpStatus.OK);
	}
	
}
