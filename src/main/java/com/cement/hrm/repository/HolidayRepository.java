package com.cement.hrm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cement.hrm.model.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer> {

	@Query(value = "EXEC fecthAllHolidaysBySearch :fromDate, :toDate, :status", nativeQuery = true)
	public List<Holiday> fecthAllHolidaysBySearch(Date fromDate, Date toDate, int status);

	@Query("select h.holidayName from com.cement.hrm.model.Holiday as h where HolidayName =:HolidayName AND HolidayId<>:HolidayId")
	public String findHolidayByName(@Param("HolidayName") String holidayName, @Param("HolidayId") int holidayId);

	@Query(value = "EXEC addEditHolidays :HolidayId, :HolidayName,:HolidayDate,:Description,:Status,:CreatedBy", nativeQuery = true)
	public String addEditHolidays(@Param("HolidayId") int holidayId, @Param("HolidayName") String holidayName,
			@Param("HolidayDate") Date holidayDate, @Param("Description") String description,
			@Param("Status") int status, @Param("CreatedBy") int createdBy);

	@Query(value = "EXEC deleteHolidayById :HolidayId", nativeQuery = true)
	public String deleteById(@Param("HolidayId") int holidayId);

	@Query(value = "EXEC changeHolidayStatus :status, :holidayId, :employeeId", nativeQuery = true)
	public String changeHolidayStatus(Integer status, Integer holidayId, Integer employeeId);
}
