package com.cement.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cement.hrm.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Procedure(value = "fecthAllEmployeeBySearch")
	public List<Employee> fecthAllEmployeeBySearch(@Param("EmployeeName") String employeeName, @Param("Designation") String designation, @Param("Status") int status, @Param("Email") String email);
}
