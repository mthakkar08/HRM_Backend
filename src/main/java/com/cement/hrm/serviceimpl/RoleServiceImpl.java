package com.cement.hrm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Role;
import com.cement.hrm.repository.RoleRepository;
import com.cement.hrm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public ResponseEntity<Role> getRoleById(int roleId) {
		Role role = roleRepository.getById(roleId);
		if(role!=null)
		 {
			return new ResponseEntity<>(role, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<List<Role>> fecthAllRoles(){
		List<Role> roleList = roleRepository.fecthAllRoles();
		return new ResponseEntity<>(roleList,HttpStatus.OK);

	}

	@Override
	public String addEditRole(Role role) {
		return roleRepository.addEditRole(role.getRoleName());
	}

	@Override
	public String deleteRoleById(int roleId) {
		
		return roleRepository.deleteById(roleId);
	}

	@Override
	public ResponseEntity<List<Role>> fetchAllRolesBySearch(String roleName) {
	
		List<Role> AllRoles = roleRepository.fetchAllRolesBySearch(roleName);
		return new ResponseEntity<>(AllRoles,HttpStatus.OK);
	}

	@Override
	public String addEditRoleRights(String roleRightsJson) {
		return roleRepository.addEditRoleRights( roleRightsJson);
	}

	@Override
	public String getRoleRightsByRoleId(int roleId) {
		return roleRepository.getRoleRightsByRoleId(roleId);
	}

}
