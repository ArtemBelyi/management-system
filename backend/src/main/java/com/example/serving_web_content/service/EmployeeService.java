package com.example.serving_web_content.service;

import org.springframework.http.ResponseEntity;
import java.util.Map;

public interface EmployeeService {
    ResponseEntity<String> signUp(Map<String, String> requestMap);
}
