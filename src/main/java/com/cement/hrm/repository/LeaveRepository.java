package com.cement.hrm.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cement.hrm.model.Leave;

//@NoRepositoryBean
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

	@Query(value = "EXEC addEditLeave :leaveId, :leaveSubject, :leaveReason, :leaveStatus, :employeeId, :approvedBy, :approvedMessage, :status, :startDate, :endDate", nativeQuery = true)
	Object addEditLeave(Integer leaveId, String leaveSubject, String leaveReason, Integer leaveStatus,
			Integer employeeId, Integer approvedBy, String approvedMessage, Integer status, Date startDate,
			Date endDate);

	@Query(value = "EXEC fetchAllLeavesBySearch :LeaveSubject, :LeaveStatus, :LeaveDate, :employeeId", nativeQuery = true)
	String fetchAllLeavesBySearch(@Param("LeaveSubject") String leaveSubject, @Param("LeaveStatus") Integer leaveStatus,
			@Param("LeaveDate") Date leaveDate, Integer employeeId);

	@Query(value = "EXEC getLeaveById :LeaveId", nativeQuery = true)
	String getLeaveById(@Param("LeaveId") int leaveId);

	@Query(value = "EXEC deleteLeaveById :LeaveId", nativeQuery = true)
	Object deleteLeaveById(@Param("LeaveId") int leaveId);

	@Query(value = "EXEC changeLeaveStatus :leaveId, :approvedBy, :approvedMessage, :leaveStatus", nativeQuery = true)
	Object changeLeaveStatus(Integer leaveId, Integer approvedBy, String approvedMessage, Integer leaveStatus);

	@Query(value = "EXEC getLeavesByReportingEmployee :LeaveSubject, :LeaveStatus, :LeaveDate, :employeeId", nativeQuery = true)
	String getLeavesByReportingEmployee(@Param("LeaveSubject") String leaveSubject,
			@Param("LeaveStatus") Integer leaveStatus, @Param("LeaveDate") Date leaveDate, Integer employeeId);

}
