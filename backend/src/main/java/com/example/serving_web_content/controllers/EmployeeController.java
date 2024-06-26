package com.example.serving_web_content.controllers;

import com.example.serving_web_content.models.Employee;
import com.example.serving_web_content.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @DeleteMapping("employees")
    public void deleteEmployee(@RequestParam Long id) {
        this.employeeRepository.deleteById(id);
    }
}
