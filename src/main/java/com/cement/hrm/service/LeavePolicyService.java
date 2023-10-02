package com.cement.hrm.service;

import com.cement.hrm.model.LeavePolicy;

public interface LeavePolicyService {

	Object getLeavePolicyById(int leaveId);

	Object getAllLeavePolicies(LeavePolicy leavePolicy);

	Object addEditLeavePolicy(LeavePolicy leavePolicy);

	Object deleteLeavePolicyById(int leavePolicyId);

}
