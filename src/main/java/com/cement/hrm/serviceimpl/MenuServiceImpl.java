package com.cement.hrm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Menu;
import com.cement.hrm.repository.MenuRepository;
import com.cement.hrm.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public List<Menu> fecthAllMenus(int menuId) {

		return menuRepository.fecthAllMenus(menuId);

	}

}
