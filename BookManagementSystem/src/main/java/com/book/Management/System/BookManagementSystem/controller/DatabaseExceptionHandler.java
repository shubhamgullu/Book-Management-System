package com.book.Management.System.BookManagementSystem.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DatabaseExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDbConnectionError(Exception ex) {
        // Log the error or notify monitoring systems
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Database is unavailable. Please try again later.");
    }
}
