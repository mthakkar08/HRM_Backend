package com.cement.hrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.Leave;
import com.cement.hrm.request.LeaveRequest;
import com.cement.hrm.service.LeaveService;

@RestController
@CrossOrigin
@RequestMapping(UrlConstants.LEAVE)
public class LeaveController {

	@Autowired
	private LeaveService<Leave> leaveService;

	@GetMapping(UrlConstants.GET_BY_ID)
	private ResponseEntity<?> getLeaveById(@RequestParam("LeaveId") int leaveId) {
		return new ResponseEntity<>(leaveService.getLeaveById(leaveId), HttpStatus.OK);
	}

	@PostMapping(UrlConstants.LIST)
	private ResponseEntity<?> getAllLeaves(@RequestBody LeaveRequest leaveRequest) {
		return new ResponseEntity<>(leaveService.getAllLeaves(leaveRequest), HttpStatus.OK);
	}

	@PostMapping(UrlConstants.ADD_EDIT)
	private ResponseEntity<?> addEditLeave(@RequestBody Leave leaveRequest) {
		return new ResponseEntity<>(leaveService.addEditLeave(leaveRequest), HttpStatus.OK);
	}

	@DeleteMapping(UrlConstants.DELETE)
	private ResponseEntity<?> deleteLeaveById(@RequestParam("LeaveId") int leaveId) {
		return new ResponseEntity<>(leaveService.deleteLeaveById(leaveId), HttpStatus.OK);
	}
}
