package com.cement.hrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId")
	// @JsonProperty("EmployeeId")
	private int employeeId;

	// @JsonProperty("EmployeeName")
	@Column(name = "EmployeeName")
	private String employeeName;

	// @JsonProperty("Dob")
	@Column(name = "Dob")
	private String dob;

	// @JsonProperty("Gender")
	@Column(name = "Gender")
	private int gender;

	// @JsonProperty("PhoneNumber")
	@Column(name = "PhoneNumber")
	private long phoneNumber;

	// @JsonProperty("Email")
	@Column(name = "Email")
	private String email;

	// @JsonProperty("Password")
	@Column(name = "Password")
	private String password;

	// @JsonProperty("Address")
	@Column(name = "Address")
	private String address;

	// @JsonProperty("Experience")
	@Column(name = "Experience")
	private String experience;

	// @JsonProperty("Status")
	@Column(name = "Status")
	private int status;

	// @JsonProperty("HiringDate")
	@Column(name = "HiringDate")
	private Date hiringDate;

	// @JsonProperty("JoiningDate")
	@Column(name = "JoiningDate")
	private Date joiningDate;

	// @JsonProperty("TerminationDate")
	@Column(name = "TerminationDate")
	private Date terminationDate;

	// @JsonProperty("CreatedBy")
	@Column(name = "CreatedBy")
	private int createdBy;

	// @JsonProperty("CreatedDate")
	@Column(name = "CreatedDate")
	private Date createdDate;

	// @JsonProperty("ModifiedBy")
	@Column(name = "ModifiedBy")
	private Integer modifiedBy;

	// @JsonProperty("ModifiedDate")
	@Column(name = "ModifiedDate")
	private Date modifiedDate;

	// @JsonProperty("RoleId")
	@Column(name = "RoleId")
	private Integer roleId;

	// @JsonProperty("DesignationId")
	@Column(name = "DesignationId")
	private Integer designationId;

	@Transient
	// @JsonProperty("Role")
	private String roleName;

	@Transient
	// @JsonProperty("Designation")
	private String designationName;

	@Transient
	private String reportingEmployeeIds;
	
	@Transient
	private String reportingEmployeeNames;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, String email, String password) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.password = password;
	}

	
	public Employee(int employeeId, String employeeName, String dob, int gender, long phoneNumber, String email,
			String password, String address, String experience, int status, Date hiringDate, Date joiningDate,
			Date terminationDate, int createdBy, Date createdDate, Integer modifiedBy, Date modifiedDate,
			Integer roleId, Integer designationId, String roleName, String designationName, String reportingEmployeeIds,
			String reportingEmployeeNames) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.dob = dob;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.experience = experience;
		this.status = status;
		this.hiringDate = hiringDate;
		this.joiningDate = joiningDate;
		this.terminationDate = terminationDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.roleId = roleId;
		this.designationId = designationId;
		this.roleName = roleName;
		this.designationName = designationName;
		this.reportingEmployeeIds = reportingEmployeeIds;
		this.reportingEmployeeNames = reportingEmployeeNames;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public Integer getDesignationId() {
		return designationId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setDesignationId(Integer designationId) {
		this.designationId = designationId;
	}

	public String getReportingEmployeeIds() {
		return reportingEmployeeIds;
	}

	public void setReportingEmployeeIds(String reportingEmployeeIds) {
		this.reportingEmployeeIds = reportingEmployeeIds;
	}

	public String getReportingEmployeeNames() {
		return reportingEmployeeNames;
	}

	public void setReportingEmployeeNames(String reportingEmployeeNames) {
		this.reportingEmployeeNames = reportingEmployeeNames;
	}

	

}
