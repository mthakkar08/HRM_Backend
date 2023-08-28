package com.cement.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cement.hrm.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query("SELECT "+"new com.cement.hrm.model.Role(r.roleId, r.roleName, r.status, r.createdBy, r.modifiedBy)"+" FROM Role as r WHERE RoleName = :roleName or Status= :status")
	List<Role> fecthAllRoleBySearch(@Param("roleName") String roleName, @Param("status") int status);

}
