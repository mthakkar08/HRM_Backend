package com.cement.hrm.service;

import java.util.List;

import com.cement.hrm.model.Menu;

public interface MenuService {

	List<Menu> fecthAllMenus(int menuId, int status);

}
