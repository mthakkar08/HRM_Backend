package com.cement.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.Menu;
import com.cement.hrm.service.MenuService;

@RestController
@RequestMapping(UrlConstants.MENU)
public class MenuController {
	@Autowired
	private MenuService menuService;

	@GetMapping(UrlConstants.LIST)
	@Transactional(readOnly = true)
	public ResponseEntity<List<Menu>> fecthAllMenus(@Param("MenuId") int menuId, @Param("Status") int status) {
		return new ResponseEntity<>(menuService.fecthAllMenus(menuId,  status),
				HttpStatus.OK);
	}
}
