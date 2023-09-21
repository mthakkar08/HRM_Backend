package com.cement.hrm.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Employee;
import com.cement.hrm.repository.EmployeeRepository;
import com.cement.hrm.request.EmployeeRequest;
import com.cement.hrm.request.LoginRequest;
import com.cement.hrm.response.LoginResponse;
import com.cement.hrm.response.ReportingEmployee;
import com.cement.hrm.security.JwtTokenUtil;
import com.cement.hrm.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee empInDb = employeeRepository.findEmployeeByUsername(username);
		String dbPassword = encoder.encode(empInDb.getPassword());
		if (empInDb.getEmail().equals(username)) {
			return new User(empInDb.getEmail(), dbPassword, new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	@Override
	public ResponseEntity<?> loginEmployee(LoginRequest loginRequest) {

		try {
			return authenticate(loginRequest.getEmail(), loginRequest.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Employee employee = null;
		try {
			String jsonObj = employeeRepository.getEmployeeById(employeeId);
			if (jsonObj != null) {
				ObjectMapper mapper = new ObjectMapper();
				employee = mapper.readValue(jsonObj, Employee.class);
				return employee;
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> fetchAllEmployeeBySearch(EmployeeRequest searchRequest) {

		try {
			String jsonObj = employeeRepository.fetchAllEmployeeBySearch(searchRequest.getEmployeeName(),
					searchRequest.getDesignationId(), searchRequest.getStatus(), searchRequest.getEmail());
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonList = mapper.readTree(jsonObj);
			ObjectReader reader = mapper.readerFor(new TypeReference<List<Employee>>() {
			});
			List<Employee> empList = reader.readValue(jsonList);
			return empList;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String addEditEmployee(Employee employee) {
		String encryptedPassword = encoder.encode(employee.getPassword());
		return employeeRepository.addEditEmployee(employee.getEmployeeId(), employee.getEmployeeName(),
				employee.getDob(), employee.getGender(), employee.getPhoneNumber(), employee.getEmail(),
				encryptedPassword, employee.getAddress(), employee.getDesignationId(), employee.getExperience(),
				employee.getStatus(), employee.getHiringDate(), employee.getJoiningDate(),
				employee.getTerminationDate(), employee.getReportingEmployees());
	}

	@Override
	public String deleteEmployeeById(int employeeId) {
		return employeeRepository.deleteEmployeeById(employeeId);

	}

	@Override
	public String forgetPassword(String email) {
		return employeeRepository.isEmpoloyeeExist(email);

	}

	@Override
	public String resetPassword(EmployeeRequest resetRequest) {
		return employeeRepository.resetEmployeePassword(resetRequest.getEmail(), resetRequest.getPassword());

	}

	@Override
	public String updateEmployeeStatus(EmployeeRequest statusRequest) {
		Optional<Employee> empInDb = employeeRepository.findById(statusRequest.getEmployeeId());
		if (empInDb.isPresent()) {
			empInDb.get().setStatus(statusRequest.getStatus());
			employeeRepository.save(empInDb.get());
			return "SUCCESS";
		}
		return "ERROR";
	}

	@Override
	public List<ReportingEmployee> bindEmployeeList() {

		String listJson = employeeRepository.bindEmployeeList();
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<ReportingEmployee> bindList = mapper.readValue(listJson, new TypeReference<List<ReportingEmployee>>() {
			});
			return bindList;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ResponseEntity<?> authenticate(String username, String password) {
		try {
			Authentication obj = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			if (null != obj && obj.isAuthenticated()) {
				final UserDetails userDetails = loadUserByUsername(username);
				Employee empInDb = employeeRepository.findEmployeeByUsername(username);
				final String token = jwtTokenUtil.generateToken(userDetails);
				return ResponseEntity.ok(
						new LoginResponse(token, empInDb.getEmail(), empInDb.getPassword(), empInDb.getEmployeeName()));
			} else {
				return new ResponseEntity<>("", HttpStatus.UNAUTHORIZED);
			}

		} catch (DisabledException e) {
			// throw new Exception("USER_DISABLED", e);
			return new ResponseEntity<>("USER_DISABLED", HttpStatus.OK);
		} catch (BadCredentialsException e) {
			return new ResponseEntity<>("INVALID_CREDENTIALS", HttpStatus.BAD_REQUEST);
		} catch (AccountStatusException | InternalAuthenticationServiceException e) {
			return new ResponseEntity<>("Invalid Account!", HttpStatus.BAD_REQUEST);
		}

	}

}
