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
import com.cement.hrm.request.EmployeeRequest;
import com.cement.hrm.request.LoginRequest;
import com.cement.hrm.response.ReportingEmployee;
import com.cement.hrm.service.EmployeeService;

@RestController
@RequestMapping(UrlConstants.EMPLOYEE)
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(UrlConstants.LOG_IN)
	public ResponseEntity<?> loginEmployee(@RequestBody LoginRequest loginRequest) throws Exception {
		return employeeService.loginEmployee(loginRequest);

	}

	@GetMapping(UrlConstants.GET_BY_ID)
	public Employee getEmployeeById(@Param("employeeId") int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@PostMapping(UrlConstants.LIST)
	@Transactional(readOnly = true)
	public ResponseEntity<List<Employee>> fetchAllEmployeeBySearch(@RequestBody EmployeeRequest searchRequest) {
		return new ResponseEntity<>(employeeService.fetchAllEmployeeBySearch(searchRequest), HttpStatus.OK);
	}

	@PostMapping(UrlConstants.ADD_EDIT)
	public ResponseEntity<String> addEditEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEditEmployee(employee), HttpStatus.OK);
	}

	@DeleteMapping(UrlConstants.DELETE)
	public String deleteEmployeeById(@Param("employeeId") int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}

	@PostMapping(UrlConstants.FORGET)
	public ResponseEntity<String> forgetPassword(@RequestBody EmployeeRequest forgetRequest) {
		return new ResponseEntity<>(employeeService.forgetPassword(forgetRequest.getEmail()), HttpStatus.OK);
	}

	@PostMapping(UrlConstants.RESET)
	public ResponseEntity<String> resetPassword(@RequestBody EmployeeRequest resetRequest) {
		return new ResponseEntity<>(employeeService.resetPassword(resetRequest), HttpStatus.OK);
	}

	@PostMapping(UrlConstants.STATUS)
	public ResponseEntity<String> updateEmployeeStatus(@RequestBody EmployeeRequest statusRequest) {
		return new ResponseEntity<>(employeeService.updateEmployeeStatus(statusRequest), HttpStatus.OK);
	}

	@GetMapping(UrlConstants.BIND_LIST)
	public ResponseEntity<List<ReportingEmployee>> bindEmployeeList() {
		return new ResponseEntity<>(employeeService.bindEmployeeList(), HttpStatus.OK);
	}

}
