package com.sparta.currency_user.common.enums;

import lombok.Getter;

@Getter
public enum ErrorStatus {

    USER_NOT_FOUND("U001", "사용자를 찾을 수 없습니다."),
    CURRENCY_NOT_FOUND("C001", "존재하지 않는 화폐단위입니다.")
    ;

    private String code;
    private String message;

    private ErrorStatus(String code, String message){
        this.code = code;
        this.message = message;
    }

}
