package com.example.serving_web_content.dao;

import com.example.serving_web_content.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    Employee findByEmailId(@Param("email") String email);
}
