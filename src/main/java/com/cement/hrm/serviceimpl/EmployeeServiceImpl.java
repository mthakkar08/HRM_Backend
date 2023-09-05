package com.cement.hrm.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Employee;
import com.cement.hrm.repository.EmployeeRepository;
import com.cement.hrm.request.EmployeeRequest;
import com.cement.hrm.request.LoginRequest;
import com.cement.hrm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee empInDb = employeeRepository.findEmployeeByUsername(username);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String dbPassword = encoder.encode(empInDb.getPassword());
		if (empInDb.getEmail().equals(username)) {
			return new User(empInDb.getEmail(), dbPassword, new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	@Override
	public String addEditEmployee(Employee employee) {
		return employeeRepository.addEditEmployee(employee.getEmployeeId(), employee.getEmployeeName(),
				employee.getDob(), employee.getGender(), employee.getPhoneNumber(), employee.getEmail(),
				employee.getPassword(), employee.getAddress(), employee.getDesignationId(),
				employee.getExperience(), employee.getStatus(), employee.getHiringDate(), employee.getJoiningDate(),
				employee.getTerminationDate());
//		try {
//			Optional<Employee> empInDb = employeeRepository.findById(employee.getEmployeeId());
//			if (empInDb.isPresent()) {
//				Employee empToDb = new Employee();
//				empToDb = empInDb.get();
//				empToDb.setEmployeeName(employee.getEmployeeName());
//				empToDb.setDob(employee.getDob());
//				empToDb.setGender(employee.getGender());
//				empToDb.setPhoneNumber(employee.getPhoneNumber());
//				empToDb.setEmail(employee.getEmail());
//				empToDb.setPassword(employee.getPassword());
//				empToDb.setAddress(employee.getAddress());
//				empToDb.setDesignation(employee.getDesignation());
//				empToDb.setExperience(employee.getExperience());
//				empToDb.setStatus(employee.getStatus());
//				empToDb.setHiringDate(employee.getHiringDate());
//				empToDb.setJoiningDate(employee.getJoiningDate());
//				empToDb.setTerminationDate(employee.getTerminationDate());
//				empToDb.setCreatedBy(employee.getCreatedBy());
//				employeeRepository.save(empToDb);
//				return "Updated successfully";
//			} else {
//				employeeRepository.save(employee);
//				return "Saved successfully";
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;

	}

	@Override
	public List<Employee> fecthAllEmployeeBySearch(EmployeeRequest searchRequest) {
		List<Employee> employeeList = employeeRepository.fecthAllEmployeeBySearch(searchRequest.getEmployeeName(),
				searchRequest.getDesignation(), searchRequest.getStatus(), searchRequest.getEmail());
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
	public String deleteEmployeeById(int employeeId) {
		try {
			boolean isPresent = employeeRepository.existsById(employeeId);
			if (isPresent) {
				employeeRepository.deleteById(employeeId);
				return "Deleted Successfully";
			} else {
				return "Employee Doesn't Exist.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean loginEmployee(LoginRequest loginRequest) {
		String status = employeeRepository.validateUsernameAndPassword(loginRequest.getEmail(),
				loginRequest.getPassword());
		return Boolean.parseBoolean(status);
	}

	@Override
	public String forgetPassword(String email) {
		String st =employeeRepository.isEmpoloyeeExist(email);
		return st;

	}

	@Override
	public String resetPassword(EmployeeRequest resetRequest) {
		return employeeRepository.resetEmployeePassword(resetRequest.getEmail(), resetRequest.getPassword());

	}

	@Override
	public String updateEmployeeStatus(EmployeeRequest statusRequest) {
		Optional<Employee> empInDb=employeeRepository.findById(statusRequest.getEmployeeId());
		if(empInDb.isPresent()) {
			empInDb.get().setStatus(statusRequest.getStatus());
			employeeRepository.save(empInDb.get());
			return "SUCCESS";
		}
		return "ERROR";
	}

}
