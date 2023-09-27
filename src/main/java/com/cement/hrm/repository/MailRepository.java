package com.cement.hrm.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cement.hrm.model.Mail;
@Repository
public interface MailRepository extends JpaRepository<Mail, Integer> {

	@Query(value = "EXEC saveEmail :to, :from, :subject, :token, :signature, :employeeId, :url, :expiryDate", nativeQuery = true)
	public void saveEmail(String to, String from, String subject, String token, String signature, Integer employeeId,
			String url, Date expiryDate);

	@Query(value = "EXEC findEmailByToken :token", nativeQuery = true)
	public Mail findEmailByToken(String token);
}
