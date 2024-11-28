package com.sparta.currency_user.common.exception;

import com.sparta.currency_user.common.enums.ErrorStatus;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidInputException extends RuntimeException{

    private final String code;
    private final String message;
    private final HttpStatus status = HttpStatus.BAD_REQUEST;

    public InvalidInputException(ErrorStatus errorStatus){

        this.code = errorStatus.getCode();
        this.message = errorStatus.getMessage();

    }

}
