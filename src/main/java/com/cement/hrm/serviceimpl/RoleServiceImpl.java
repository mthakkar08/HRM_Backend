package com.cement.hrm.serviceimpl;

import java.util.List;
import java.util.Optional;

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
		Optional<Role> roleInDb = roleRepository.findById(roleId);
		if (roleInDb.isPresent()) {
			return new ResponseEntity<>(roleInDb.get(), HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<List<Role>> fecthAllRoleBySearch(String roleName, int status) {
		List<Role> roleList = roleRepository.fecthAllRoleBySearch(roleName, status);
		if (!roleList.isEmpty()) {
			return new ResponseEntity<>(roleList, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@Override
	public Role addEditRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> deleteRoleById(int roleId) {
		boolean isPresent = roleRepository.existsById(roleId);
		if (isPresent) {
			roleRepository.deleteById(roleId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

}
