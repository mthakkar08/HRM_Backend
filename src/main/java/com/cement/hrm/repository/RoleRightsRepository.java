package com.cement.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cement.hrm.model.RoleRights;

@Repository
public interface RoleRightsRepository extends JpaRepository<RoleRights, Integer>{
	
	@Query(value = "EXEC addEditRoleRights :RoleRightsJson", nativeQuery = true)
	public String addEditRoleRights(@Param("RoleRightsJson")String roleRightsJson);
}
	