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

import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        if (validateSignUp(requestMap)) {
            Employee employee = employeeDao.findByEmailId(requestMap.get("email"));
            if (Objects.isNull(employee)) {

            } else {
                return Utils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
            }
        } else {
            return Utils.getResponseEntity(Constants.INVALID_DATA, HttpStatus.BAD_REQUEST);
        }
        return null;
    }

    private boolean validateSignUp(Map<String, String> request) {
        return request.containsKey("name") && request.containsKey("number") && request.containsKey("email") && request.containsKey("password");
    }
}
