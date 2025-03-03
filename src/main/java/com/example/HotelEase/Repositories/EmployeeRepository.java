package com.example.HotelEase.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.HotelEase.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {


	    @Query("SELECT e FROM Employee e WHERE " +
	            "(:id IS NULL OR e.employeeID = :id) AND " +
	            "(:name IS NULL OR LOWER(e.employeeName) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
	            "(:position IS NULL OR LOWER(e.employeePosition) LIKE LOWER(CONCAT('%', :position, '%'))) AND " +
	            "(:department IS NULL OR LOWER(e.employeeDepartment) LIKE LOWER(CONCAT('%', :department, '%')))")
	    List<Employee> searchEmployees(
	            @Param("id") Integer id,
	            @Param("name") String name,
	            @Param("position") String position,
	            @Param("department") String department);

}
