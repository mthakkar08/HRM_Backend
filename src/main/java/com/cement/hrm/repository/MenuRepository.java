package com.cement.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cement.hrm.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

	@Query("SELECT "
			+ "new com.cement.hrm.model.Menu(m.menuId, m.parentMenuId, m.menuName,m.status,m.createdBy,m.modifiedBy)"
			+ " FROM Menu as m WHERE MenuId = :MenuId or Status<>2")
	public List<Menu> fecthAllMenus(@Param("MenuId") int menuId);

}
