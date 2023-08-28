package com.cement.hrm.service;

import java.util.List;

import com.cement.hrm.model.Employee;
import com.cement.hrm.request.LoginRequest;

public interface EmployeeService {

	String addEditEmployee(Employee employee);

	List<Employee> fecthAllEmployeeBySearch(String employeeName, String designation, int status, String email);

	Employee getEmployeeById(int employeeId);

	String deleteEmployeeById(int employeeId);

	boolean loginEmployee(LoginRequest loginRequest);

}
