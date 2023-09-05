package com.cement.hrm.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cement.hrm.model.Employee;
import com.cement.hrm.request.EmployeeRequest;
import com.cement.hrm.request.LoginRequest;

public interface EmployeeService extends UserDetailsService {

	String addEditEmployee(Employee employee);

	List<Employee> fecthAllEmployeeBySearch(EmployeeRequest searchRequest);

	Employee getEmployeeById(int employeeId);

	String deleteEmployeeById(int employeeId);

	boolean loginEmployee(LoginRequest loginRequest);

	String forgetPassword(String email);

	String resetPassword(EmployeeRequest resetRequest);

	String updateEmployeeStatus(EmployeeRequest statusRequest);

}
