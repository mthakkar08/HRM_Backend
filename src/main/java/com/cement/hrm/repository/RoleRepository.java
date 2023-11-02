package com.cement.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cement.hrm.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

//	@Query("SELECT "+"new com.cement.hrm.model.Role(r.roleId, r.roleName, r.status, r.createdBy, r.modifiedBy)"+" FROM Role as r WHERE RoleName = :roleName or Status= :status")
//	List<Role> fecthAllRoleBySearch(@Param("RoleName") String roleName, @Param("Status") int status);

	@Query(value ="EXEC deleteRoleById :RoleId", nativeQuery = true)
	String deleteById(@Param("RoleId")int roleId);

	@Query(value = "EXEC addEditRole :RoleName",nativeQuery = true)
	String addEditRole(@Param("RoleName")String roleName);
	
	@Query("SELECT new com.cement.hrm.model.Role(r.roleId, r.roleName, r.status, r.createdBy, r.modifiedBy) FROM Role as r WHERE Status <> 2 and RoleName like "+"%"+":RoleName"+"%")
	List<Role> fetchAllRolesBySearch(@Param("RoleName")String roleName);
	
	@Query("SELECT new com.cement.hrm.model.Role(r.roleId, r.roleName, r.status, r.createdBy, r.modifiedBy) FROM Role as r WHERE Status <> 2")
	List<Role> fecthAllRoles();
	
	@Query("SELECT new com.cement.hrm.model.Role(r.roleId, r.roleName, r.status, r.createdBy, r.modifiedBy) FROM com.cement.hrm.model.Role as r WHERE RoleId = :RoleId and Status=1")
	Role getById(@Param("RoleId") int roleId);
}
