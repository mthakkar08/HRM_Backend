package com.cement.hrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.LeaveBalance;
import com.cement.hrm.service.LeaveBalanceService;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.LEAVE_BALANCE)
public class LeaveBalanceController {

	@Autowired
	private LeaveBalanceService leaveBalanceService;

	@GetMapping(UrlConstants.GET_BY_ID)
	private ResponseEntity<?> getLeaveBalanceById(@RequestParam("EmployeeId") Integer employeeId) {
		return new ResponseEntity<>(leaveBalanceService.getLeaveBalanceById(employeeId), HttpStatus.OK);
	}

	@PostMapping(UrlConstants.ADD_EDIT)
	private ResponseEntity<?> addEditCompoffLeave(@RequestBody LeaveBalance CompoffLeaveRequest) {
		return new ResponseEntity<>(leaveBalanceService.addEditCompoffLeave(CompoffLeaveRequest), HttpStatus.OK);
	}
}
