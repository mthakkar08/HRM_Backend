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
import com.cement.hrm.model.LeavePolicy;
import com.cement.hrm.service.LeavePolicyService;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.LEAVE_POLICY)
public class LeavePolicyController {

	@Autowired
	private LeavePolicyService leavePolicyService;

	@GetMapping(UrlConstants.GET_BY_ID)
	private ResponseEntity<?> getLeavePolicyById(@RequestParam("LeavePolicyId") int leaveId) {
		return new ResponseEntity<>(leavePolicyService.getLeavePolicyById(leaveId), HttpStatus.OK);
	}

	@PostMapping(UrlConstants.LIST)
	private ResponseEntity<?> getAllLeavePolicies(@RequestBody LeavePolicy leavePolicy) {
		return new ResponseEntity<>(leavePolicyService.getAllLeavePolicies(leavePolicy), HttpStatus.OK);
	}

	@PostMapping(UrlConstants.ADD_EDIT)
	private ResponseEntity<?> addEditLeavePolicy(@RequestBody LeavePolicy leavePolicy) {
		return new ResponseEntity<>(leavePolicyService.addEditLeavePolicy(leavePolicy), HttpStatus.OK);
	}

	@DeleteMapping(UrlConstants.DELETE)
	private ResponseEntity<?> deleteLeavePolicyById(@RequestParam("LeavePolicyId") int leavePolicyId) {
		return new ResponseEntity<>(leavePolicyService.deleteLeavePolicyById(leavePolicyId), HttpStatus.OK);
	}
}
