package com.cement.hrm.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cement.hrm.model.LeavePolicy;

public interface LeavePolicyRepository extends CrudRepository<LeavePolicy, Integer> {

	@Query(value="addEditLeavePolicy :leavePolicyId, :employeeId, :leaveCount, :status, :startFrom, :endTo", nativeQuery = true)
	Object addEditLeavePolicy(int leavePolicyId, int employeeId, int leaveCount, int status, Date startFrom, Date endTo);

}
