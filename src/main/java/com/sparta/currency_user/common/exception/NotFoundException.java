package com.sparta.currency_user.common.exception;

import com.sparta.currency_user.common.enums.ErrorStatus;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException{

    private final String code;
    private final String message;
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public NotFoundException(ErrorStatus errorStatus){
        this.code = errorStatus.getCode();
        this.message = errorStatus.getMessage();

    }

}
