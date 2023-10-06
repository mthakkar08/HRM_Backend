package com.cement.hrm.service;

import com.cement.hrm.model.LeaveBalance;

public interface LeaveBalanceService {

	Object getLeaveBalanceById(Integer employeeId);

	Object addEditCompoffLeave(LeaveBalance CompoffLeaveRequest);

}
