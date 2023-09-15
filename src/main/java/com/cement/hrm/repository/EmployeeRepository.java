package com.cement.hrm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.cement.hrm.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Procedure(value = "fecthAllEmployeeBySearch")
	public List<Employee> fetchAllEmployeeBySearch(@Param("EmployeeName") String employeeName,
			@Param("Designation") int designation, @Param("Status") int status, @Param("Email") String email);

	@Query(value = "EXEC validateUsernameAndPassword :Email, :Password", nativeQuery = true)
	public String validateUsernameAndPassword(@Param("Email") String email, @Param("Password") String password);

	@Query("SELECT new com.cement.hrm.model.Employee(e.employeeName, e.email, e.password) FROM Employee as e WHERE Email IS NOT NULL AND Email=:email")
	public Employee findEmployeeByUsername(String email);

	@Query(value = "EXEC addEditEmployee :EmployeeId, :EmployeeName, :Dob, :Gender, :PhoneNumber, :Email, :Password, :Address, :Designation, :Experience, :Status, :HiringDate, :JoiningDate, :TerminationDate", nativeQuery = true)
	public String addEditEmployee(@Param("EmployeeId") int employeeId, @Param("EmployeeName") String employeeName,
			@Param("Dob") String dob, @Param("Gender") int gender, @Param("PhoneNumber") long phoneNumber,
			@Param("Email") String email, @Param("Password") String password, @Param("Address") String address,
			@Param("Designation") int designationId, @Param("Experience") String experience,
			@Param("Status") int status, @Param("HiringDate") Date hiringDate, @Param("JoiningDate") Date joiningDate,
			@Param("TerminationDate") Date terminationDate);

	@Query(value = "EXEC isEmpoloyeeExist :Email", nativeQuery = true)
	public String isEmpoloyeeExist(@Param("Email") String email);

	@Query(value = "EXEC resetEmployeePassword :Email, :Password", nativeQuery = true)
	public String resetEmployeePassword(@Param("Email") String email, @Param("Password") String password);

	@Query(value = "EXEC bindEmployeeList", nativeQuery = true)
	public String bindEmployeeList();

}
