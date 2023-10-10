package com.cement.hrm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cement.hrm.model.RoleRights;

public interface RoleRightsService {

	ResponseEntity<List<RoleRights>> fecthAllRoleRightsBySearch();

	String addEditRoleRights(String roleRightsJson);
	
	String getRoleRightsById(int roleId);

}
