package com.example.serving_web_content.serviceImpl;

import com.example.serving_web_content.constants.Constants;
import com.example.serving_web_content.dao.EmployeeDao;
import com.example.serving_web_content.models.Employee;
import com.example.serving_web_content.service.EmployeeService;
import com.example.serving_web_content.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            if (validateSignUp(requestMap)) {
                Employee employee = employeeDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(employee)) {
                    employeeDao.save(getEmployeeFromMap(requestMap));
                    return Utils.getResponseEntity("Successfully registered", HttpStatus.OK);
                } else {
                    return Utils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
                }
            } else {
                return Utils.getResponseEntity(Constants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Utils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private boolean validateSignUp(Map<String, String> request) {
        return request.containsKey("name") && request.containsKey("number") && request.containsKey("email") && request.containsKey("password");
    }

    // convert employee Dto to employee entity
    private Employee getEmployeeFromMap(Map<String, String> request) {
        Employee employee = new Employee();
        employee.setName(request.get("name"));
        employee.setEmail(request.get("email"));
        employee.setPassword(request.get("password"));
        employee.setNumber(request.get("number"));
        employee.setStatus("false");
        employee.setRole("user");

        return employee;
    }
}
