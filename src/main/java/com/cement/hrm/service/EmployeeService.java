package com.cement.hrm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.cement.hrm.model.Employee;
import com.cement.hrm.request.EmployeeRequest;
import com.cement.hrm.request.LoginRequest;

public interface EmployeeService extends UserDetailsService {

	ResponseEntity<?> loginEmployee(LoginRequest loginRequest);

	Employee getEmployeeById(int employeeId);

	List<Employee> fetchAllEmployeeBySearch(EmployeeRequest searchRequest);

	String addEditEmployee(Employee employee);

	String deleteEmployeeById(int employeeId);

	String forgetPassword(String email);

	String resetPassword(EmployeeRequest resetRequest);

	String updateEmployeeStatus(EmployeeRequest statusRequest);

}
