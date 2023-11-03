package com.cement.hrm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cement.hrm.model.Role;

public interface RoleService {

	ResponseEntity<Role> getRoleById(int roleId);

	String addEditRole(Role role);

	String deleteRoleById(int roleId);

	ResponseEntity<List<Role>> fecthAllRoles();

	ResponseEntity<List<Role>> fetchAllRolesBySearch(String roleName);

	String addEditRoleRights(String roleRightsJson);

	String getRoleRightsByRoleId(int roleId);
}
