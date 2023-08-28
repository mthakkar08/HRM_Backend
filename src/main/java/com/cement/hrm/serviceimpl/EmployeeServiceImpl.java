package com.cement.hrm.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Employee;
import com.cement.hrm.repository.EmployeeRepository;
import com.cement.hrm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEditEmployee(Employee employee) {
		Optional<Employee> empInDb = employeeRepository.findById(employee.getEmployeeId());
		if (empInDb.isPresent()) {
			Employee empToDb = new Employee();
			empToDb = empInDb.get();
			empToDb.setEmployeeName(employee.getEmployeeName());
			empToDb.setDob(employee.getDob());
			empToDb.setGender(employee.getGender());
			empToDb.setPhoneNumber(employee.getPhoneNumber());
			empToDb.setEmail(employee.getEmail());
			empToDb.setPassword(employee.getPassword());
			empToDb.setAddress(employee.getAddress());
			empToDb.setDesignation(employee.getDesignation());
			empToDb.setExperience(employee.getExperience());
			empToDb.setStatus(employee.getStatus());
			empToDb.setHiringDate(employee.getHiringDate());
			empToDb.setJoiningDate(employee.getJoiningDate());
			empToDb.setTerminationDate(employee.getTerminationDate());
			empToDb.setCreatedBy(employee.getCreatedBy());
			return employeeRepository.save(empToDb);
		} else {
			return employeeRepository.save(employee);
		}

	}

	@Override
	public List<Employee> fecthAllEmployeeBySearch(String employeeName, String designation, int status, String email) {
		List<Employee> employeeList = employeeRepository.fecthAllEmployeeBySearch(employeeName, designation, status,
				email);
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		boolean isPresent = employeeRepository.existsById(employeeId);
		if (isPresent) {
			employeeRepository.deleteById(employeeId);
		}

	}

}
