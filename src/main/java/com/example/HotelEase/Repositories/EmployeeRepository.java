package com.example.HotelEase.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelEase.Entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
