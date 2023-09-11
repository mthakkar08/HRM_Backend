package com.cement.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.Designation;
import com.cement.hrm.service.DesignationService;

@RestController
@CrossOrigin
@RequestMapping(UrlConstants.DESIGNATION)
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@GetMapping(UrlConstants.BIND_LIST)
	private ResponseEntity<List<Designation>> bindDesignationList() {
		return new ResponseEntity<>(designationService.bindDesignationList(), HttpStatus.OK);
	}
}
