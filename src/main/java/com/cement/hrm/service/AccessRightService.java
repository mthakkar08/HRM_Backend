package com.cement.hrm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cement.hrm.model.AccessRight;

public interface AccessRightService {

	ResponseEntity<AccessRight> getAccessRightById(int accessRightId);
	
	
	ResponseEntity<List<AccessRight>> fecthAllAccessRights();


}
