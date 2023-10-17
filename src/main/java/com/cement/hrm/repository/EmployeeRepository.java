package com.cement.hrm.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cement.hrm.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// @Procedure(value = "fecthAllEmployeeBySearch")
	@Query(value = "EXEC fecthAllEmployeeBySearch :EmployeeName, :DesignationId, :Status, :Email", nativeQuery = true)
	public String fetchAllEmployeeBySearch(@Param("EmployeeName") String employeeName,
			@Param("DesignationId") int designationId, @Param("Status") int status, @Param("Email") String email);

	@Query(value = "EXEC validateUsernameAndPassword :Email, :Password", nativeQuery = true)
	public String validateUsernameAndPassword(@Param("Email") String email, @Param("Password") String password);

	@Query("SELECT new com.cement.hrm.model.Employee(e.employeeId, e.employeeName, e.email, e.password) FROM Employee as e WHERE Email IS NOT NULL AND Email=:email")
	public Employee findEmployeeByUsername(String email);

	@Query(value = "EXEC addEditEmployee :EmployeeId, :EmployeeName, :Dob, :Gender, :PhoneNumber, :Email, :Password, :Address, :Designation, :Experience, :Status, :HiringDate, :JoiningDate, :TerminationDate, :ReportingEmployees", nativeQuery = true)
	public String addEditEmployee(@Param("EmployeeId") int employeeId, @Param("EmployeeName") String employeeName,
			@Param("Dob") String dob, @Param("Gender") int gender, @Param("PhoneNumber") long phoneNumber,
			@Param("Email") String email, @Param("Password") String password, @Param("Address") String address,
			@Param("Designation") int designationId, @Param("Experience") String experience,
			@Param("Status") int status, @Param("HiringDate") Date hiringDate, @Param("JoiningDate") Date joiningDate,
			@Param("TerminationDate") Date terminationDate, @Param("ReportingEmployees") String reportingEmployees);

	@Query(value = "EXEC isEmpoloyeeExist :Email", nativeQuery = true)
	public String isEmpoloyeeExist(@Param("Email") String email);

	@Query(value = "EXEC resetEmployeePassword :Email, :Password", nativeQuery = true)
	public String resetEmployeePassword(@Param("Email") String email, @Param("Password") String password);

	@Query(value = "EXEC bindEmployeeList", nativeQuery = true)
	public String bindEmployeeList();

	@Query(value = "EXEC getEmployeeById :employeeId", nativeQuery = true)
	public String getEmployeeById(int employeeId);

	@Query(value = "EXEC deleteEmployeeById :employeeId", nativeQuery = true)
	public String deleteEmployeeById(int employeeId);

	@Query(value = "SELECT [dbo].[FUNC_MANAGE_EMPLOYEE](-1)", nativeQuery = true)
	public String manageEmployees();

}
