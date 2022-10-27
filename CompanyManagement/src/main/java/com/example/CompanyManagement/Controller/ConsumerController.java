package com.example.CompanyManagement.Controller;

import com.example.CompanyManagement.Model.Employee;
import com.example.CompanyManagement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public String registerEmp(@RequestBody Employee employee){
        return employeeService.registerEmp(employee);
    }

    @PostMapping("/login")
    public String loginEmp(@RequestBody Employee employee){
        return employeeService.loginEmp(employee);
    }


}
