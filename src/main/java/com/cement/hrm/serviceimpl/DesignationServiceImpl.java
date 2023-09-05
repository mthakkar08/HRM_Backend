package com.cement.hrm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Designation;
import com.cement.hrm.repository.DesignationRepository;
import com.cement.hrm.service.DesignationService;

@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired
	private DesignationRepository designationRepository;

	@Override
	public List<Designation> bindDesignationList() {
		return designationRepository.findAll();
	}

}
