package com.cement.hrm.service;

import java.util.List;

import com.cement.hrm.model.Employee;

public interface EmployeeService {

	Employee addEditEmployee(Employee employee);

	List<Employee> fecthAllEmployeeBySearch(String employeeName, String designation, int status, String email);

	Employee getEmployeeById(int employeeId);

	void deleteEmployeeById(int employeeId);

}
