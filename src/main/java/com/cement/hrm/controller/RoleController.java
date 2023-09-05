package com.cement.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.Role;
import com.cement.hrm.service.RoleService;

@RestController
@RequestMapping(UrlConstants.ROLE)
@CrossOrigin
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping(UrlConstants.GET_BY_ID)
	public ResponseEntity<Role> getRoleById(@Param("roleId") int roleId) {
		return roleService.getRoleById(roleId);
	}

	@GetMapping(UrlConstants.LIST)
	@Transactional(readOnly = true)
	public ResponseEntity<List<Role>> fecthAllRoleBySearch(@Param("roleName") String roleName,
			@Param("status") int status) {
		return roleService.fecthAllRoleBySearch(roleName, status);
	}

	@PostMapping(UrlConstants.ADD_EDIT)
	public ResponseEntity<Role> addEditRole(@RequestBody Role role) {
		return new ResponseEntity<>(roleService.addEditRole(role), HttpStatus.OK);
	}

	@DeleteMapping(UrlConstants.DELETE)
	public ResponseEntity<?> deleteRoleById(@Param("roleId") int roleId) {
		return roleService.deleteRoleById(roleId);
	}
}
