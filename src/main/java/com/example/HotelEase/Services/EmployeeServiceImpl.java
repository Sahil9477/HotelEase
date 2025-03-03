package com.example.HotelEase.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelEase.Entities.Employee;
import com.example.HotelEase.Repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
    @Override
    public Employee updateEmployee(Integer id, Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        
        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();
            employee.setEmployeeName(updatedEmployee.getEmployeeName());
            employee.setEmployeePosition(updatedEmployee.getEmployeePosition());
            employee.setEmployeeDepartment(updatedEmployee.getEmployeeDepartment());
            return employeeRepository.save(employee); // Save updated employee
        }
        
        return null; // Handle case where employee ID does not exist
    }
    @Override
    public List<Employee> searchEmployees(Integer id, String name, String position, String department) {
        return employeeRepository.searchEmployees(id, name, position, department);
    }
}
