package com.cement.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.AccessRight;
import com.cement.hrm.service.AccessRightService;

@RestController
@RequestMapping(UrlConstants.ACCESSRIGHT)
@CrossOrigin
public class AccessRightController {

	@Autowired
	private AccessRightService accessRightService;

	@GetMapping(UrlConstants.GET_BY_ID)
	public ResponseEntity<AccessRight> getAccessRightById(@RequestParam("AccessRightId") int accessRightId) {
		return accessRightService.getAccessRightById(accessRightId);
	}

	@GetMapping(UrlConstants.LIST)
	@Transactional(readOnly = true)
	public ResponseEntity<List<AccessRight>> fecthAllRoles() {
		return accessRightService.fecthAllAccessRights();
	}
//
//	@PostMapping(UrlConstants.ADD_EDIT)
//	public  String addEditRole(@RequestBody Role role) {
//		return roleService.addEditRole(role);
//	}
//
//	@DeleteMapping(UrlConstants.DELETE)
//	public String deleteRoleById(@Param("RoleId") int roleId) {
//		return roleService.deleteRoleById(roleId);
//	}
//	
//	@GetMapping(UrlConstants.SEARCH)
//	public ResponseEntity<List<Role>> fecthAllRoleBySearch(@RequestParam("RoleName")String roleName) {
//		return roleService.fetchAllRolesBySearch(roleName);
//	}
 
}
