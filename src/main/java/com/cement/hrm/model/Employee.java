package com.cement.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId")
	private int employeeId;

	@Column(name = "EmployeeName")
	private String employeeName;

	@Column(name = "Dob")
	private String dob;

	@Column(name = "Gender")
	private int gender;

	@Column(name = "PhoneNumber")
	private long phoneNumber;

	@Column(name = "Email")
	private String email;

	@Column(name = "Password")
	private String password;

	@Column(name = "Address")
	private String address;

	@OneToOne
	@JoinColumn(name = "DesignationId")
	private Designation designation;

	@Column(name = "Experience")
	private String experience;

	@Column(name = "Status")
	private int status;

	@Column(name = "HiringDate")
	private Date hiringDate;

	@Column(name = "JoiningDate")
	private Date joiningDate;

	@Column(name = "TerminationDate")
	private Date terminationDate;

	@Column(name = "CreatedBy")
	private int createdBy;

	@ManyToOne
	@JoinColumn(name = "RoleId")
	private Role role;

	public Employee() {
		super();
	}

	public Employee(String employeeName, String email, String password) {
		this.employeeName = employeeName;
		this.email = email;
		this.password = password;
	}

	public Employee(int employeeId, String employeeName, String dob, int gender, long phoneNumber, String email,
			String password, String address, Designation designation, String experience, int status, Date hiringDate,
			Date joiningDate, Date terminationDate, int createdBy, Role role) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dob = dob;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.designation = designation;
		this.experience = experience;
		this.status = status;
		this.hiringDate = hiringDate;
		this.joiningDate = joiningDate;
		this.terminationDate = terminationDate;
		this.createdBy = createdBy;
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(Date hiringDate) {
		this.hiringDate = hiringDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
