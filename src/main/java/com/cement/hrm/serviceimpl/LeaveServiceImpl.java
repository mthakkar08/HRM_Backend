package com.cement.hrm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Leave;
import com.cement.hrm.repository.LeaveRepository;
import com.cement.hrm.request.LeaveRequest;
import com.cement.hrm.service.LeaveService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LeaveServiceImpl<T> implements LeaveService<T> {

	@Autowired
	private LeaveRepository leaveRepository;

	@Override
	public Object getLeaveById(int leaveId) {
		Leave leaveObj = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonObj = leaveRepository.getLeaveById(leaveId);
			if (jsonObj != null) {
				leaveObj = mapper.readValue(jsonObj, new TypeReference<Leave>() {
				});
				return leaveObj;
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return leaveObj;
	}

	@Override
	public Object getAllLeaves(LeaveRequest leaveRequest) {
		List<Leave> leaveList = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonObj = leaveRepository.fetchAllLeavesBySearch(leaveRequest.getLeaveSubject(),
					leaveRequest.getLeaveStatus(), leaveRequest.getLeaveDate(), leaveRequest.getEmployeeId());
			if (jsonObj != null) {
				leaveList = mapper.readValue(jsonObj, new TypeReference<List<Leave>>() {
				});
				return leaveList;
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return leaveList;
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

	@Override
	public Object changeLeaveStatus(LeaveRequest statusRequest) {
		return leaveRepository.changeLeaveStatus(statusRequest.getLeaveId(), statusRequest.getApprovedBy(),
				statusRequest.getApprovedMessage(), statusRequest.getLeaveStatus());
	}

	@Override
	public Object getLeavesByReportingEmployee(LeaveRequest leaveRequest) {
		List<Leave> leaveList = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonObj = leaveRepository.getLeavesByReportingEmployee(leaveRequest.getLeaveSubject(),
					leaveRequest.getLeaveStatus(), leaveRequest.getLeaveDate(), leaveRequest.getEmployeeId());
			if (jsonObj != null) {
				leaveList = mapper.readValue(jsonObj, new TypeReference<List<Leave>>() {
				});
				return leaveList;
			}

		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return leaveList;
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