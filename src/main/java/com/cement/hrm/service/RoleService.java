package com.cement.hrm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cement.hrm.model.Role;

public interface RoleService {

	ResponseEntity<Role> getRoleById(int roleId);

	ResponseEntity<List<Role>> fecthAllRoleBySearch(String roleName, int status);

	Role addEditRole(Role role);

	ResponseEntity<?> deleteRoleById(int roleId);

}
