package com.sparta.currency_user.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Map<String, String>> invalidInputException(InvalidInputException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("errorCode", ex.getCode()); //자동으로 관련 코드 들어옴
        errorResponse.put("errorMessage", ex.getMessage()); //자동으로 관련 메세지 들어옴

        return ResponseEntity
                .status(ex.getStatus()) //ex.getStatus() == HttpStatus.BAD_REQUEST
                .body(errorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> notFoundException(NotFoundException ex) {

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("errorCode", ex.getCode()); //자동으로 관련 코드 들어옴
        errorResponse.put("errorMessage", ex.getMessage()); //자동으로 관련 메세지 들어옴

        return ResponseEntity
                .status(ex.getStatus())
                .body(errorResponse);
    }



}

