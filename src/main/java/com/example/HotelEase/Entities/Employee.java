package com.example.HotelEase.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeID;
    
    private String employeeName;
    private String employeePosition;
    private String employeeDepartment;
	private Double salary;
	public String getEmployeePosition() {
		return employeePosition;
	}
	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
	public Integer getEmployeeID() {
		// TODO Auto-generated method stub
		return this.employeeID;
	}
}
