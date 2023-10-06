package com.cement.hrm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.LeaveBalance;
import com.cement.hrm.repository.LeaveBalanceRepository;
import com.cement.hrm.service.LeaveBalanceService;

@Service
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

	@Autowired
	private LeaveBalanceRepository leaveBalanceRepository;
	
	@Override
	public Object getLeaveBalanceById(Integer employeeId) {
		return leaveBalanceRepository.getLeaveBalanceById(employeeId);
	}

	@Override
	public Object addEditCompoffLeave(LeaveBalance CompoffLeaveRequest) {
		return leaveBalanceRepository.addEditCompoffLeave(CompoffLeaveRequest.getCompoffLeave(),
				CompoffLeaveRequest.getEmployeeId(), CompoffLeaveRequest.getReportingEmployee());
	}

}
