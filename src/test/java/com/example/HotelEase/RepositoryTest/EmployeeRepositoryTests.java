package com.example.HotelEase.RepositoryTest;



import com.example.HotelEase.Entities.Employee;
import com.example.HotelEase.Repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        // Initialize an Employee object before each test
        employee = new Employee();
        employee.setEmployeeName("John Doe");
        employee.setEmployeePosition("Manager");
        employee.setEmployeeDepartment("HR");
        employee.setSalary(75000.0);
    }

    @Test
    public void testSaveEmployee() {
        // Test saving an Employee
        Employee savedEmployee = employeeRepository.save(employee);
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getEmployeeID()).isGreaterThan(0); // Check if ID is generated
    }

    @Test
    public void testFindEmployeeById() {
        // Test retrieving an Employee by ID
        Employee savedEmployee = employeeRepository.save(employee); // Save first
        Employee foundEmployee = employeeRepository.findById(savedEmployee.getEmployeeID()).orElse(null);
        assertThat(foundEmployee).isNotNull();
        assertThat(foundEmployee.getEmployeeID()).isEqualTo(savedEmployee.getEmployeeID());
    }

    @Test
    public void testUpdateEmployee() {
        // Test updating an Employee
        Employee savedEmployee = employeeRepository.save(employee); // Save first
        savedEmployee.setEmployeePosition("Senior Manager");
        Employee updatedEmployee = employeeRepository.save(savedEmployee);
        assertThat(updatedEmployee).isNotNull();
        assertThat(updatedEmployee.getEmployeePosition()).isEqualTo("Senior Manager");
    }

    @Test
    public void testDeleteEmployee() {
        // Test deleting an Employee
        Employee savedEmployee = employeeRepository.save(employee); // Save first
        employeeRepository.deleteById(savedEmployee.getEmployeeID());
        Employee deletedEmployee = employeeRepository.findById(savedEmployee.getEmployeeID()).orElse(null);
        assertThat(deletedEmployee).isNull(); // The employee should be deleted
    }
    
    @Test
    public void testFindAllEmployees() {
        // Test fetching all employees
        employeeRepository.save(employee); // Save employee
        Iterable<Employee> employees = employeeRepository.findAll();
        assertThat(employees).isNotEmpty(); // Ensure that the list is not empty
    }
}




/**
 * 
 * Test Setup (@BeforeEach): The setUp method initializes the Employee entity before each test. This allows you to use the same employee object for different tests.
testSaveEmployee: This test ensures that an Employee is saved correctly to the database. It checks if the employee is not null and if the generated ID is greater than 0 (indicating that it was saved).
testFindEmployeeById: After saving an Employee, this test verifies that the employee can be retrieved by its ID.
testUpdateEmployee: This test ensures that an Employee can be updated. It modifies the position of an employee and saves the updated employee. Then, it verifies that the position was updated correctly.
testDeleteEmployee: This test ensures that an employee can be deleted from the database. It first saves the employee, deletes it by ID, and then verifies that the employee no longer exists.
testFindAllEmployees: This test checks if there are any employees stored in the database. It ensures that the findAll method returns a non-empty list after an employee is added.

 * 
 * */
