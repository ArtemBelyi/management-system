package com.example.serving_web_content.service;

import com.example.serving_web_content.models.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> findAll();
    ResponseEntity<String> signUp(Map<String, String> requestMap);
}
