package com.example.serving_web_content.restImpl;

import com.example.serving_web_content.constants.Constants;
import com.example.serving_web_content.rest.EmployeeRest;
import com.example.serving_web_content.service.EmployeeService;
import com.example.serving_web_content.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeRestImpl implements EmployeeRest {

    @Autowired
    EmployeeService employeeService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requiestMap) {
        try {
            return employeeService.signUp(requiestMap);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Utils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
