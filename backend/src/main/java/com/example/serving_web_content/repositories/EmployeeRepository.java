package com.example.serving_web_content.repositories;

import com.example.serving_web_content.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
