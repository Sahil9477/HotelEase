package com.example.HotelEase.Services;

import java.util.List;

import com.example.HotelEase.Entities.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer id);
    Employee addEmployee(Employee employee);
    void deleteEmployee(Integer id);
    Employee updateEmployee(Integer id, Employee updatedEmployee);
    // New method for dynamic search
    List<Employee> searchEmployees(Integer id, String name, String position, String department);

}

