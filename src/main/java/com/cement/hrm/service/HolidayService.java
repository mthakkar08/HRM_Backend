package com.cement.hrm.service;


import java.util.List;

import com.cement.hrm.model.Holiday;
import com.cement.hrm.request.HolidayRequest;

public interface HolidayService {

	String addEditHoliday(Holiday holidays);

	List<Holiday> fecthAllHolidaysBySearch(HolidayRequest searchRequest);
	
	Holiday getHolidayById(int holidayId);

	String deleteHolidayById(int holidayId);

}
