package com.cement.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
import com.cement.hrm.response.LoginResponse;
import com.cement.hrm.security.JwtTokenUtil;
import com.cement.hrm.service.EmployeeService;

@RestController
@RequestMapping(UrlConstants.EMPLOYEE)
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@PostMapping(UrlConstants.LOG_IN)
	public ResponseEntity<?> loginEmployee(@RequestBody LoginRequest loginRequest) throws Exception {
		boolean status = employeeService.loginEmployee(loginRequest);
		if (status) {
			ResponseEntity<?> token = createAuthenticationToken(loginRequest);
			return token;
		}
		return new ResponseEntity<>("Bad Credentials", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(UrlConstants.GET_BY_ID)
	public Employee getEmployeeById(@Param("employeeId") int employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}

	@PostMapping(UrlConstants.LIST)
	@Transactional(readOnly = true)
	public ResponseEntity<List<Employee>> fecthAllEmployeeBySearch(@RequestBody EmployeeRequest searchRequest) {
		return new ResponseEntity<>(employeeService.fecthAllEmployeeBySearch(searchRequest), HttpStatus.OK);
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

	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest)
			throws Exception {

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		final UserDetails userDetails = employeeService.loadUserByUsername(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new LoginResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
