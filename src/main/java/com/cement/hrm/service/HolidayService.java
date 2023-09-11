package com.cement.hrm.service;


import java.util.Date;
import java.util.List;

import com.cement.hrm.model.Holiday;

public interface HolidayService {

	Holiday addEditHoliday(Holiday holidays);

	List<Holiday> fecthAllHolidaysBySearch(Date fromDate, Date toDate);

	void deleteHolidayById(int holidaysId);

}
