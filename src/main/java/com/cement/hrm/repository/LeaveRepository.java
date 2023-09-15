package com.cement.hrm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cement.hrm.model.Leave;

//@NoRepositoryBean
public interface LeaveRepository extends JpaRepository<Leave, Integer> {

	@Query(value = "EXEC addEditLeave :leaveId, :leaveSubject, :leaveReason, :leaveStatus, :employeeId, :approvedBy, :approvedMessage, :status, :startDate, :endDate", nativeQuery = true)
	Object addEditLeave(int leaveId, String leaveSubject, String leaveReason, int leaveStatus, int employeeId,
			int approvedBy, String approvedMessage, int status, Date startDate, Date endDate);

	@Query(value = "EXEC fetchAllLeavesBySearch :LeaveSubject, :LeaveStatus, :Status, :LeaveDate", nativeQuery = true)
	List<Leave> fetchAllLeavesBySearch(@Param("LeaveSubject") String leaveSubject,
			@Param("LeaveStatus") int leaveStatus, @Param("Status") int status, @Param("LeaveDate") Date leaveDate);

	@Query(value = "EXEC getLeaveById :LeaveId", nativeQuery = true)
	Leave getLeaveById(@Param("LeaveId") int leaveId);

	@Query(value = "EXEC deleteLeaveById :LeaveId", nativeQuery = true)
	Object deleteLeaveById(@Param("LeaveId") int leaveId);

}
