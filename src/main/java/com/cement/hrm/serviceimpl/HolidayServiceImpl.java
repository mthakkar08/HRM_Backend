package com.cement.hrm.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Holiday;
import com.cement.hrm.repository.HolidayRepository;
import com.cement.hrm.request.HolidayRequest;
import com.cement.hrm.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	private HolidayRepository holidayRepository;

//	@Override
//	public String addEditHoliday(Holiday holiday) {
//		String holidayName = holidayRepository.findHolidayByName(holiday.getHolidayName(), holiday.getHolidayId());
//		if (holidayName == null || 
//				holidayName.isEmpty()) {
//			Optional<Holiday> HolInDb = holidayRepository.findById(holiday.getHolidayId());
//			if (HolInDb.isPresent()) {
//				Holiday holToDb = new Holiday();
//				holToDb = HolInDb.get();
//				holToDb.setHolidayDate(holiday.getHolidayDate());
//				holToDb.setStatus(holiday.getStatus());
//				holToDb.setHolidayName(holiday.getHolidayName());
//				holToDb.setCreatedDate(holiday.getCreatedDate());
//				holToDb.setDescription(holiday.getDescription());
//				holToDb.setCreatedBy(holiday.getCreatedBy());
//				holToDb.setModifiedBy(holiday.getModifiedBy());
//				holToDb.setModifiedDate(holiday.getModifiedDate());
//				holidayRepository.save(holToDb);
//				return "UPDATED";
//			} else {
//				holidayRepository.save(holiday);
//				return "SUCCESS";
//			}
//
//		} else {
//			return "Holiday  already exist!";
//		}
//
//	}
	@Override
	public String addEditHoliday(Holiday holiday) {
		
		return holidayRepository.addEditHolidays(holiday.getHolidayId(), holiday.getHolidayName(), holiday.getHolidayDate(), holiday.getDescription(), holiday.getStatus(), holiday.getCreatedBy());
		
	}

	@Override
	public List<Holiday> fecthAllHolidaysBySearch(HolidayRequest searchRequest) {
		return holidayRepository.fecthAllHolidaysBySearch(searchRequest.getFromDate(), searchRequest.getToDate(),
				searchRequest.getStatus());
	}

	@Override
	public String deleteHolidayById(int holidayId) {
		
		return holidayRepository.deleteById(holidayId);

	}

	@Override
	public Holiday getHolidayById(int holidayId) {
		Optional<Holiday> holiday = holidayRepository.findById(holidayId);
		if (holiday.isPresent()) {
			return holiday.get();
		}
		return null;
	}

}
