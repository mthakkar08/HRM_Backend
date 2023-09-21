package com.cement.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cement.hrm.model.AccessRight;

@Repository
public interface AccessRightRepository extends JpaRepository<AccessRight, Integer> {

//	@Query("SELECT "+"new com.cement.hrm.model.Role(r.roleId, r.roleName, r.status, r.createdBy, r.modifiedBy)"+" FROM Role as r WHERE RoleName = :roleName or Status= :status")
//	List<Role> fecthAllRoleBySearch(@Param("RoleName") String roleName, @Param("Status") int status);
//
//	@Query(value ="EXEC deleteRoleById :RoleId", nativeQuery = true)
//	String deleteById(@Param("RoleId")int roleId);
//
//	@Query(value = "EXEC addEditRole :RoleId, :RoleName, :Status, :CreatedBy, :ModifiedBy",nativeQuery = true)
//	String addEditRole(@Param("RoleId")int roleId,@Param("RoleName")String roleName,@Param("Status") int status,@Param("CreatedBy")int createdBy,@Param("ModifiedBy") int modifiedBy);
//	
//	@Query("SELECT new com.cement.hrm.model.Role(r.roleId, r.roleName, r.status, r.createdBy, r.modifiedBy) FROM Role as r WHERE Status <> 2 and RoleName like :RoleName")
//	List<Role> fetchAllRolesBySearch(@Param("RoleName")String roleName);
	
	@Query("SELECT new com.cement.hrm.model.AccessRight(a.accessRightId, a.accessRightName, a.status, a.createdBy, a.modifiedBy) FROM AccessRight as a WHERE Status <> 2")
	List<AccessRight> fecthAllAccessRights();
//	
	@Query("SELECT new com.cement.hrm.model.AccessRight(a.accessRightId, a.accessRightName, a.status, a.createdBy, a.modifiedBy) FROM AccessRight as a WHERE AccessRightId = :AccessRightId and Status=1")
	AccessRight getAccessRightById(@Param("AccessRightId") int accessRightId);
}
