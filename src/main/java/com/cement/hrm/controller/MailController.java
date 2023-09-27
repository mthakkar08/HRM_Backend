package com.cement.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.Mail;
import com.cement.hrm.service.MailService;

@RestController
@RequestMapping(UrlConstants.MAIL)
public class MailController {

	@Autowired
	MailService emailService;

	@GetMapping(UrlConstants.LIST)
	public ResponseEntity<List<Mail>> getAllEmails() {
		return new ResponseEntity<List<Mail>>(emailService.getAllEmails(), HttpStatus.OK);
	}
}
