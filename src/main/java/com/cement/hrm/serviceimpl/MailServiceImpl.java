package com.cement.hrm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Mail;
import com.cement.hrm.repository.MailRepository;
import com.cement.hrm.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	MailRepository emailRepository;

	@Override
	public List<Mail> getAllEmails() {
		// TODO Auto-generated method stub
		return emailRepository.findAll();
	}
}
