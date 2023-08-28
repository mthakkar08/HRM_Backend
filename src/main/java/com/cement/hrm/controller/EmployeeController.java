package com.cement.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.Employee;
import com.cement.hrm.request.LoginRequest;
import com.cement.hrm.service.EmployeeService;

@RestController
@RequestMapping(UrlConstants.EMPLOYEE)
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(UrlConstants.EMPLOYEE_BY_ID)
	public Employee getEmployeeById(@Param("employeeId") int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@PostMapping(UrlConstants.EMPLOYEE_ADD_EDIT)
	public ResponseEntity<String> addEditEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEditEmployee(employee), HttpStatus.OK);
	}

	@GetMapping(UrlConstants.EMPLOYEE_LIST)
	@Transactional(readOnly = true)
	public ResponseEntity<List<Employee>> fecthAllEmployeeBySearch(@Param("employeeName") String employeeName,
			@Param("designation") String designation, @Param("status") int status, @Param("email") String email) {
		return new ResponseEntity<>(employeeService.fecthAllEmployeeBySearch(employeeName, designation, status, email),
				HttpStatus.OK);
	}

	@DeleteMapping(UrlConstants.EMPLOYEE_DELETE)
	public String deleteEmployeeById(@Param("employeeId") int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}

	@PostMapping("/login")
	public boolean loginEmployee(@RequestBody LoginRequest loginRequest) {
		return employeeService.loginEmployee(loginRequest);
	}
}
