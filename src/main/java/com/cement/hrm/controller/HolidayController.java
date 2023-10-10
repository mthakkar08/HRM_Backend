package com.cement.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cement.hrm.constant.UrlConstants;
import com.cement.hrm.model.Holiday;
import com.cement.hrm.request.HolidayRequest;
import com.cement.hrm.service.HolidayService;

@RestController
@RequestMapping(UrlConstants.HOLIDAY)
@CrossOrigin
public class HolidayController {

	@Autowired
	private HolidayService holidayService;

	@GetMapping(UrlConstants.GET_BY_ID)
	public Holiday getHolidayById(@Param("employeeId") int holidayId) {
		return holidayService.getHolidayById(holidayId);
	}

	@PostMapping(UrlConstants.ADD_EDIT)
	public ResponseEntity<String> addEditHoliday(@RequestBody Holiday holiday) {
		return new ResponseEntity<>(holidayService.addEditHoliday(holiday), HttpStatus.OK);
	}

	@PostMapping(UrlConstants.LIST)
	@Transactional(readOnly = true)
	public ResponseEntity<List<Holiday>> fetchAllHolidaysBySearch(@RequestBody HolidayRequest searchRequest) {
		return new ResponseEntity<>(holidayService.fecthAllHolidaysBySearch(searchRequest), HttpStatus.OK);
	}

	@DeleteMapping(UrlConstants.DELETE)
	public String deleteHolidayById(@Param("HolidayId") int holidayId) {
		return holidayService.deleteHolidayById(holidayId);
	}

	@PostMapping(UrlConstants.STATUS)
	public String changeHolidayStatus(@RequestBody HolidayRequest holidayRequest) {
		return holidayService.changeHolidayStatus(holidayRequest);
	}
}
