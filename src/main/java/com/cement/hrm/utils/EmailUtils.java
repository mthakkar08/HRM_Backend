package com.cement.hrm.utils;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.cement.hrm.model.Mail;

@Component
public class EmailUtils {

	@Autowired
	JavaMailSender emailSender;

	@Autowired
	SpringTemplateEngine templateEngine;

	public boolean isExpired(Date expiryDate) {
		return new Date().after(expiryDate);
	}

	public String sendMail(Mail emailObj) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			Context context = new Context();
			context.setVariables(emailObj.getModel());
			String html = templateEngine.process("email-template", context);
			helper.setTo(emailObj.getTo());
			helper.setText(html, true);
			helper.setSubject(emailObj.getSubject());
			helper.setFrom(emailObj.getFrom());
			emailSender.send(message);
			return "SUCCESS";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
