package com.cement.hrm.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Emails")
public class Mail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "To")
	private String to;

	@Column(name = "From")
	private String from;

	@Column(name = "Subject")
	private String subject;

	@Column(name = "Token")
	private String token;

	@Column(name = "Signature")
	private String signature;

	@Column(name = "EmployeeId")
	private Integer employeeId;

	@Column(name = "Url")
	private String url;

	@Column(name = "ExpiryDate")
	private Date expiryDate;

	@Transient
	private Employee employee;

	@Transient
	private Map<String, Object> model;

	public Mail() {
		super();
	}

	public Mail(int id, String to, String from, String subject, String token, String signature, Integer employeeId,
			String url, Date expiryDate, Employee employee, Map<String, Object> model) {
		super();
		this.id = id;
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.token = token;
		this.signature = signature;
		this.employeeId = employeeId;
		this.url = url;
		this.expiryDate = expiryDate;
		this.employee = employee;
		this.model = model;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setExpiryDate(int minutes) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, minutes);
		this.expiryDate = now.getTime();
	}

	public Map<String, Object> getModel() {
		return model;
	}

	public void setModel(Map<String, Object> model) {
		this.model = model;
	}

}
