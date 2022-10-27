package com.example.CompanyManagement.ResponseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class MyResponse {
    public static ResponseEntity<Object> generateCustomResponseFormat(String message, HttpStatus status, Object responseObj){
        Map<String, Object> mapObject = new HashMap<>();

        mapObject.put("Message", message);
        mapObject.put("status", status.value());
        mapObject.put("Data", responseObj);
        return new ResponseEntity<>(mapObject, status);
    }
}
