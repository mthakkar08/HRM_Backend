package com.cement.hrm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.AccessRight;
import com.cement.hrm.repository.AccessRightRepository;
import com.cement.hrm.service.AccessRightService;

@Service
public class AccessRightServiceImpl implements AccessRightService {

	@Autowired
	private AccessRightRepository accessRightRepository;


	@Override
	public ResponseEntity<AccessRight> getAccessRightById(int accessRightId) {
		AccessRight accessRight = accessRightRepository.getAccessRightById(accessRightId);
		if(accessRight !=null)
		 {
			return new ResponseEntity<>(accessRight , HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<AccessRight>> fecthAllAccessRights() {
		List<AccessRight > accessRightList  = accessRightRepository.fecthAllAccessRights();
		return new ResponseEntity<>(accessRightList,HttpStatus.OK);
	}

	



}
