package com.cement.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cement.hrm.model.LeaveBalance;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer> {

	@Query(value = "EXEC getLeaveBalanceById :employeeId", nativeQuery = true)
	LeaveBalance getLeaveBalanceById(Integer employeeId);

	@Query(value = "EXEC addEditCompoffLeave :compoffLeave, :employeeId, :ReportingEmployee", nativeQuery = true)
	String addEditCompoffLeave(Integer compoffLeave, Integer employeeId, Integer ReportingEmployee);

}
