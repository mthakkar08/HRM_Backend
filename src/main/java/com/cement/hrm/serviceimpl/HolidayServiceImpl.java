package com.cement.hrm.serviceimpl;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cement.hrm.model.Holiday;
import com.cement.hrm.repository.HolidayRepository;
import com.cement.hrm.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	private HolidayRepository holidayRepository;

	@Override
	public Holiday addEditHoliday(Holiday holiday) {
		Optional<Holiday> HolInDb = holidayRepository.findById(holiday.getHolidayId());
		if (HolInDb.isPresent()) {
			Holiday holToDb = new Holiday();
			holToDb = HolInDb.get();
			holToDb.setHolidayDate(holiday.getHolidayDate());
			holToDb.setStatus(holiday.getStatus());
			holToDb.setHolidayName(holiday.getHolidayName());
			holToDb.setCreatedDate(holiday.getCreatedDate());
			holToDb.setDescription(holiday.getDescription());
			holToDb.setCreatedBy(holiday.getCreatedBy());
			holToDb.setModifiedBy(holiday.getModifiedBy());
			holToDb.setModifiedDate(holiday.getModifiedDate());

			return holidayRepository.save(holToDb);
		} else {
			return holidayRepository.save(holiday);
		}

	}

	@Override
	public List<Holiday> fecthAllHolidaysBySearch(Date fromDate, Date toDate) {
		return holidayRepository.fecthAllHolidaysBySearch(fromDate, toDate);
	}

	@Override
	public void deleteHolidayById(int holidayId) {
		boolean isPresent = holidayRepository.existsById(holidayId);
		if (isPresent) {
			holidayRepository.deleteById(holidayId);
		}

	}

}
