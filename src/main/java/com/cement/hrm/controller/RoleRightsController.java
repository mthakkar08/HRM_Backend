package com.cement.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.RoleRights;
import com.cement.hrm.service.RoleRightsService;

@RestController
@RequestMapping(UrlConstants.ROLERIGHTS)
@CrossOrigin
public class RoleRightsController {
	
	@Autowired
	private RoleRightsService roleRightsService;

	@GetMapping(UrlConstants.LIST)
	@Transactional(readOnly = true)
	public ResponseEntity<List<RoleRights>> fecthAllRoleRightsBySearch() {
		return roleRightsService.fecthAllRoleRightsBySearch();
	}

	@PostMapping(UrlConstants.ADD_EDIT)
	public String addEditRole(@RequestBody String roleRightsJson) {
		return roleRightsService.addEditRoleRights(roleRightsJson);
	}
	@GetMapping(UrlConstants.GET_BY_ID)
	@Transactional(readOnly = true)
	public ResponseEntity<?> getRoleRightsById(@RequestParam int roleId) {
		return new ResponseEntity<>(roleRightsService.getRoleRightsById(roleId),HttpStatus.OK);
	}
}
