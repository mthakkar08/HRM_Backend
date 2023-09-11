package com.cement.hrm.serviceimpl;

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
import com.cement.hrm.security.JwtTokenUtil;
import com.cement.hrm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

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
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isPresent()) {
			return employee.get();
		}
		return null;
	}

	@Override
	public List<Employee> fetchAllEmployeeBySearch(EmployeeRequest searchRequest) {
		List<Employee> employeeList = employeeRepository.fetchAllEmployeeBySearch(searchRequest.getEmployeeName(),
				searchRequest.getDesignation(), searchRequest.getStatus(), searchRequest.getEmail());
		return employeeList;
	}

	@Override
	public String addEditEmployee(Employee employee) {
		return employeeRepository.addEditEmployee(employee.getEmployeeId(), employee.getEmployeeName(),
				employee.getDob(), employee.getGender(), employee.getPhoneNumber(), employee.getEmail(),
				employee.getPassword(), employee.getAddress(), employee.getDesignationId(), employee.getExperience(),
				employee.getStatus(), employee.getHiringDate(), employee.getJoiningDate(),
				employee.getTerminationDate());
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
	public String forgetPassword(String email) {
		String st = employeeRepository.isEmpoloyeeExist(email);
		return st;

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

	private ResponseEntity<?> authenticate(String username, String password) {
		try {
			Authentication obj = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			if (null != obj && obj.isAuthenticated()) {
				final UserDetails userDetails = loadUserByUsername(username);
				final String token = jwtTokenUtil.generateToken(userDetails);
				return ResponseEntity.ok(new LoginResponse(token, userDetails));
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
