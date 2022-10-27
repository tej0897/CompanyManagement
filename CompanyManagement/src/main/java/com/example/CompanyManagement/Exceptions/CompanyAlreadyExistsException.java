package com.example.CompanyManagement.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason="Company already exists in Database!")
public class CompanyAlreadyExistsException extends Exception{

}
