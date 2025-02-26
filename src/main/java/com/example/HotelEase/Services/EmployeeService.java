package com.example.HotelEase.Services;

import java.util.List;

import com.example.HotelEase.Entities.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    Employee addEmployee(Employee employee);
    void deleteEmployee(Integer id);
}

