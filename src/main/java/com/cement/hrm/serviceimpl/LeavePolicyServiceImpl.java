package com.cement.hrm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.LeavePolicy;
import com.cement.hrm.repository.LeavePolicyRepository;
import com.cement.hrm.service.LeavePolicyService;

@Service
public class LeavePolicyServiceImpl implements LeavePolicyService {

	@Autowired
	private LeavePolicyRepository leavePolicyRepository;

	@Override
	public Object getLeavePolicyById(int leavePolicyId) {
		return leavePolicyRepository.findById(leavePolicyId);
	}

	@Override
	public Object getAllLeavePolicies(LeavePolicy leavePolicy) {
		return leavePolicyRepository.findAll();
	}

	@Override
	public Object addEditLeavePolicy(LeavePolicy leavePolicy) {
		return leavePolicyRepository.addEditLeavePolicy(leavePolicy.getLeavePolicyId(), leavePolicy.getEmployeeId(),
				leavePolicy.getLeaveCount(), leavePolicy.getStatus(), leavePolicy.getStartFrom(),
				leavePolicy.getEndTo());
	}

	@Override
	public Object deleteLeavePolicyById(int leavePolicyId) {
		leavePolicyRepository.deleteById(leavePolicyId);
		return "SUCCESS";
	}

}
