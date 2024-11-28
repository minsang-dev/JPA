package com.sparta.currency_user.exchange.enums;

import lombok.Getter;

@Getter
public enum ExchangeStatus {

    NORMAL("환전 성공"),
    CANCELLED("환전 취소");

    private String text;

    private ExchangeStatus(String text) {
        this.text = text;
    }

}
