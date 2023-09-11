package com.cement.hrm.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	@PostMapping(UrlConstants.ADD_EDIT)
	public ResponseEntity<Holiday> addEditHoliday(@RequestBody Holiday holiday) {
		return new ResponseEntity<>(holidayService.addEditHoliday(holiday), HttpStatus.OK);
	}

	@GetMapping(UrlConstants.LIST)
	@Transactional(readOnly = true)
	public ResponseEntity<List<Holiday>> fetchAllHolidaysBySearch(@RequestBody HolidayRequest searchRequest) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date from = formatter.parse(searchRequest.getFromDate());
		Date to = formatter.parse(searchRequest.getToDate());
		return new ResponseEntity<>(holidayService.fecthAllHolidaysBySearch(from, to), HttpStatus.OK);
	}

	@DeleteMapping(UrlConstants.DELETE)
	public void deleteHolidayById(@Param("HolidayId") int holidayId) {
		holidayService.deleteHolidayById(holidayId);
	}
}
