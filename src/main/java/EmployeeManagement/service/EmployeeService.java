package EmployeeManagement.service;

import EmployeeManagement.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Page<Employee> getEmployees(
            int page,
            int size,
            String sortBy,
            String direction
    );

    Employee updateEmployee(
            Long id,
            Employee employee
    );

    void deleteEmployee(Long id);
}