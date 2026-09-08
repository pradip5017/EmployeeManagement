package EmployeeManagement.serviceImpl;

import EmployeeManagement.entity.Employee;
import EmployeeManagement.repository.EmployeeRepository;
import EmployeeManagement.service.EmployeeService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl
        implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(
            Employee employee) {

        if (employeeRepository
                .existsByEmail(employee.getEmail())) {

            throw new RuntimeException(
                    "Employee email already exists");
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return employeeRepository
                .findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Employee not found with id: "
                                        + id));
    }

    @Override
    public Page<Employee> getEmployees(
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort;

        if (direction.equalsIgnoreCase("desc")) {

            sort = Sort.by(sortBy).descending();

        } else {

            sort = Sort.by(sortBy).ascending();
        }

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        sort
                );

        return employeeRepository
                .findAll(pageable);
    }

    @Override
    public Employee updateEmployee(
            Long id,
            Employee employee) {

        Employee existingEmployee =
                getEmployeeById(id);

        existingEmployee.setName(
                employee.getName());

        existingEmployee.setEmail(
                employee.getEmail());

        existingEmployee.setDepartment(
                employee.getDepartment());

        existingEmployee.setPosition(
                employee.getPosition());

        existingEmployee.setSalary(
                employee.getSalary());

        existingEmployee.setDateOfJoining(
                employee.getDateOfJoining());

        return employeeRepository.save(
                existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee =
                getEmployeeById(id);

        employeeRepository.delete(employee);
    }
}