package EmployeeManagement.controller;


import EmployeeManagement.entity.Employee;
import EmployeeManagement.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(
            EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(
            @RequestBody Employee employee) {

        return new ResponseEntity<>(
                employeeService.createEmployee(employee),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/getByid{id}")
    public ResponseEntity<Employee> getEmployee(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                employeeService.getEmployeeById(id)
        );
    }

    // GET ALL + PAGINATION + SORTING
    @GetMapping("/getAll")
    public ResponseEntity<Page<Employee>> getEmployees(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size,

            @RequestParam(defaultValue = "id")
            String sortBy,

            @RequestParam(defaultValue = "asc")
            String direction) {

        return ResponseEntity.ok(
                employeeService.getEmployees(
                        page,
                        size,
                        sortBy,
                        direction
                )
        );
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(

            @PathVariable Long id,

            @RequestBody Employee employee) {

        return ResponseEntity.ok(
                employeeService.updateEmployee(
                        id,
                        employee
                )
        );
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(
                "Employee deleted successfully "+id
        );
    }
}