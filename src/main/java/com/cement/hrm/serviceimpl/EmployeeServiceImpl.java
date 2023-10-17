package com.cement.hrm.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.cement.hrm.constant.Config;
import com.cement.hrm.model.Employee;
import com.cement.hrm.model.Mail;
import com.cement.hrm.repository.EmployeeRepository;
import com.cement.hrm.repository.MailRepository;
import com.cement.hrm.request.EmployeeRequest;
import com.cement.hrm.request.LoginRequest;
import com.cement.hrm.response.LoginResponse;
import com.cement.hrm.response.ReportingEmployee;
import com.cement.hrm.security.JwtTokenUtil;
import com.cement.hrm.service.EmployeeService;
import com.cement.hrm.utils.EmailUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Value("${spring.mail.username}")
	private String fromEmail;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private MailRepository emailRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private EmailUtils emailUtils;

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
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonObj = employeeRepository.getEmployeeById(employeeId);
			if (jsonObj != null) {
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
		List<Employee> empList = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonObj = employeeRepository.fetchAllEmployeeBySearch(searchRequest.getEmployeeName(),
					searchRequest.getDesignationId(), searchRequest.getStatus(), searchRequest.getEmail());
			if (jsonObj != null) {
				JsonNode jsonList = mapper.readTree(jsonObj);
				ObjectReader reader = mapper.readerFor(new TypeReference<List<Employee>>() {
				});
				empList = reader.readValue(jsonList);
				return empList;
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empList;

	}

	@Override
	public String addEditEmployee(Employee employee) {
		String encryptedPassword = employee.getPassword() != null ? encoder.encode(employee.getPassword()) : "";
		return employeeRepository.addEditEmployee(employee.getEmployeeId(), employee.getEmployeeName(),
				employee.getDob(), employee.getGender(), employee.getPhoneNumber(), employee.getEmail(),
				encryptedPassword, employee.getAddress(), employee.getDesignationId(), employee.getExperience(),
				employee.getStatus(), employee.getHiringDate(), employee.getJoiningDate(),
				employee.getTerminationDate(), employee.getReportingEmployeeIds());
	}

	@Override
	public String deleteEmployeeById(int employeeId) {
		return employeeRepository.deleteEmployeeById(employeeId);

	}

	@Override
	public String forgetPassword(String email) {
		Employee user = employeeRepository.findEmployeeByUsername(email);
		if (user != null) {

			Map<String, Object> claims = new HashMap<>();
			final String token = jwtTokenUtil.doGenerateToken(claims, user.getEmail());
			Map<String, Object> model = new HashMap<>();
			model.put("token", token);
			model.put("user", user);
			model.put("signature", Config.SIGNATURE);
			model.put("resetUrl", Config.RESET_PASSWORD_URL + token);

			Mail emailObj = new Mail();
			emailObj.setToken(token);
			emailObj.setEmployeeId(user.getEmployeeId());
			emailObj.setEmployee(user);
			emailObj.setExpiryDate(30);
			emailObj.setFrom(fromEmail);
			emailObj.setTo(user.getEmail());
			emailObj.setSubject("Reset Password");
			emailObj.setSignature(Config.SIGNATURE);
			emailObj.setUrl(Config.RESET_PASSWORD_URL);
			emailObj.setModel(model);
			String status = emailUtils.sendMail(emailObj);
			if (status.equalsIgnoreCase("SUCCESS")) {
				emailRepository.saveEmail(emailObj.getTo(), emailObj.getFrom(), emailObj.getSubject(),
						emailObj.getToken(), emailObj.getSignature(), emailObj.getEmployeeId(), emailObj.getUrl(),
						emailObj.getExpiryDate());
				return status;
			}

		}
		return "ERROR";

	}

	@Override
	public String resetPassword(EmployeeRequest resetRequest) {
		Mail mail = emailRepository.findEmailByToken(resetRequest.getResetToken());
		if (mail != null) {
			boolean status = emailUtils.isExpired(mail.getExpiryDate());
			if (!status)
				return employeeRepository.resetEmployeePassword(mail.getTo(), resetRequest.getPassword());
		}
		return "Link Expired!";

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
		List<ReportingEmployee> reportingEmployees = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonObj = employeeRepository.bindEmployeeList();
			if (jsonObj != null) {
				reportingEmployees = mapper.readValue(jsonObj, new TypeReference<List<ReportingEmployee>>() {
				});
				return reportingEmployees;
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return reportingEmployees;
	}

	private ResponseEntity<?> authenticate(String username, String password) {
		try {
			Authentication obj = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			if (null != obj && obj.isAuthenticated()) {
				final UserDetails userDetails = loadUserByUsername(username);
				Employee empInDb = employeeRepository.findEmployeeByUsername(username);
				final String token = jwtTokenUtil.generateToken(userDetails);
				return ResponseEntity.ok(new LoginResponse(token, empInDb.getEmail(), empInDb.getPassword(),
						empInDb.getEmployeeName(), empInDb.getEmployeeId()));
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

	@Override
	public List<Employee> manageEmployees() {
		List<Employee> manageEmployees = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonObj = employeeRepository.manageEmployees();
			if (jsonObj != null) {
				manageEmployees = mapper.readValue(jsonObj, new TypeReference<List<Employee>>() {
				});
				return manageEmployees;
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return manageEmployees;
	}

}
