package com.cement.hrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class LeaveBalance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeaveBalanceId")
	private Integer leaveBalanceId;

	@Column(name = "LeavePolicyId")
	private Integer leavePolicyId;

	@Column(name = "EmployeeId")
	private Integer employeeId;

	@Column(name = "TotalLeave")
	private Integer totalLeave;

	@Column(name = "TotalEntitleLeave")
	private Integer totalEntitleLeave;

	@Column(name = "UsedLeave")
	private Integer usedLeave;

	@Column(name = "CompoffLeave")
	private Integer compoffLeave;

	@Column(name = "Status")
	private Integer status;

	@Transient
	private Integer reportingEmployee;

	public LeaveBalance() {
		super();
	}

	public LeaveBalance(Integer leaveBalanceId, Integer leavePolicyId, Integer employeeId, Integer totalLeave,
			Integer totalEntitleLeave, Integer usedLeave, Integer compoffLeave, Integer status,
			Integer reportingEmployee) {
		super();
		this.leaveBalanceId = leaveBalanceId;
		this.leavePolicyId = leavePolicyId;
		this.employeeId = employeeId;
		this.totalLeave = totalLeave;
		this.totalEntitleLeave = totalEntitleLeave;
		this.usedLeave = usedLeave;
		this.compoffLeave = compoffLeave;
		this.status = status;
		this.reportingEmployee = reportingEmployee;
	}

	public Integer getLeaveBalanceId() {
		return leaveBalanceId;
	}

	public void setLeaveBalanceId(Integer leaveBalanceId) {
		this.leaveBalanceId = leaveBalanceId;
	}

	public Integer getLeavePolicyId() {
		return leavePolicyId;
	}

	public void setLeavePolicyId(Integer leavePolicyId) {
		this.leavePolicyId = leavePolicyId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getTotalLeave() {
		return totalLeave;
	}

	public void setTotalLeave(Integer totalLeave) {
		this.totalLeave = totalLeave;
	}

	public Integer getTotalEntitleLeave() {
		return totalEntitleLeave;
	}

	public void setTotalEntitleLeave(Integer totalEntitleLeave) {
		this.totalEntitleLeave = totalEntitleLeave;
	}

	public Integer getUsedLeave() {
		return usedLeave;
	}

	public void setUsedLeave(Integer usedLeave) {
		this.usedLeave = usedLeave;
	}

	public Integer getCompoffLeave() {
		return compoffLeave;
	}

	public void setCompoffLeave(Integer compoffLeave) {
		this.compoffLeave = compoffLeave;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getReportingEmployee() {
		return reportingEmployee;
	}

	public void setReportingEmployee(Integer reportingEmployee) {
		this.reportingEmployee = reportingEmployee;
	}

}
