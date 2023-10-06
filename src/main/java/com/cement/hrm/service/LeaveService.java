package com.cement.hrm.service;

import org.springframework.stereotype.Service;

import com.cement.hrm.model.Leave;
import com.cement.hrm.request.LeaveRequest;

@Service
public interface LeaveService<T> {

	Object getLeaveById(int leaveId);

	Object getAllLeaves(LeaveRequest leaveRequest);

	Object addEditLeave(Leave leaveRequest);

	Object deleteLeaveById(int leaveId);

	Object changeLeaveStatus(LeaveRequest statusRequest);

	Object getLeavesByReportingEmployee(LeaveRequest leaveRequest);

}
