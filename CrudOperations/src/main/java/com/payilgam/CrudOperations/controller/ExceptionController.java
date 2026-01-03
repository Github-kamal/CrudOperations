package com.payilgam.CrudOperations.controller;


import com.payilgam.CrudOperations.pojo.ErrorHandler;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice

public class ExceptionController {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleValidationException(ConstraintViolationException ex) {
        List<String> errorMessages = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getMessage())
                .collect(Collectors.toList());
    return ResponseEntity.status(400).body(new ErrorHandler(errorMessages.toString(),400,System.currentTimeMillis()));
    }

}

