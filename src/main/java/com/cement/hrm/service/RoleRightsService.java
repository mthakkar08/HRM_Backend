package com.cement.hrm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cement.hrm.model.RoleRights;

public interface RoleRightsService {

	ResponseEntity<RoleRights> getRoleById(int roleRightsId);

	ResponseEntity<List<RoleRights>> fecthAllRoleRightsBySearch(String roleName, int status);

	RoleRights addEditRole(RoleRights role);

	ResponseEntity<?> deleteRoleById(int roleId);
}
