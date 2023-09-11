package com.cement.hrm.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cement.hrm.model.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

	@Procedure(value = "fecthAllHolidaysBySearch")
	public List<Holiday> fecthAllHolidaysBySearch(@Param("FromDate") Date fromDate, @Param("ToDate") Date toDate);

}
