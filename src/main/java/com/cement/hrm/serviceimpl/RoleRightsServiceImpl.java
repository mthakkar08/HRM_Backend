package com.cement.hrm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.RoleRights;
import com.cement.hrm.repository.RoleRightsRepository;
import com.cement.hrm.service.RoleRightsService;
@Service
public class RoleRightsServiceImpl implements RoleRightsService{

	@Autowired
	private RoleRightsRepository roleRightsRepository;
	
	@Override
	public ResponseEntity<List<RoleRights>> fecthAllRoleRightsBySearch() {

		List<RoleRights> AllRoleRights = roleRightsRepository.findAll();
		return new ResponseEntity<>(AllRoleRights,HttpStatus.OK);
	}

	@Override
	public String addEditRoleRights(String roleRightsJson) {
		return roleRightsRepository.addEditRoleRights( roleRightsJson);
	}

}
