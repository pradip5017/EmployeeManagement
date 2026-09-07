package EmployeeManagement.dto;

import EmployeeManagement.entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeResponse {

    private Long id;
    private String name;
    private String email;
    private String department;
    private String position;
    private BigDecimal salary;
    private LocalDate dateOfJoining;

    public EmployeeResponse(Employee employee) {

        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.department = employee.getDepartment();
        this.position = employee.getPosition();
        this.salary = employee.getSalary();
        this.dateOfJoining = employee.getDateOfJoining();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }
}
