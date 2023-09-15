package com.cement.hrm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Leave;
import com.cement.hrm.repository.LeaveRepository;
import com.cement.hrm.request.LeaveRequest;
import com.cement.hrm.service.LeaveService;

@Service
public class LeaveServiceImpl<T> implements LeaveService<T> {

	@Autowired
	private LeaveRepository leaveRepository;

	@Override
	public Object getLeaveById(int leaveId) {
		return leaveRepository.getLeaveById(leaveId);
	}

	@Override
	public Object getAllLeaves(LeaveRequest leaveRequest) {
		List<Leave> list = leaveRepository.fetchAllLeavesBySearch(leaveRequest.getLeaveSubject(),
				leaveRequest.getLeaveStatus(), leaveRequest.getStatus(), leaveRequest.getLeaveDate());
		return list;
	}

	@Override
	public Object addEditLeave(Leave leaveRequest) {
		return leaveRepository.addEditLeave(leaveRequest.getLeaveId(), leaveRequest.getLeaveSubject(),
				leaveRequest.getLeaveReason(), leaveRequest.getLeaveStatus(), leaveRequest.getEmployeeId(),
				leaveRequest.getApprovedBy(), leaveRequest.getApprovedMessage(), leaveRequest.getStatus(),
				leaveRequest.getStartDate(), leaveRequest.getEndDate());
	}

	@Override
	public Object deleteLeaveById(int leaveId) {
		return leaveRepository.deleteLeaveById(leaveId);
	}

}
//private final BaseRepository<T> baseRepository;
//
//public LeaveServiceImpl(BaseRepository<T> baseRepository) {
//    this.baseRepository = baseRepository;
//}

//@Autowired
//public final void setLogRepository(BaseRepository<T> _baseRepository) {
//    this.baseRepository = _baseRepository;
//}
//@Autowired
//protected BaseRepository baseRepository;