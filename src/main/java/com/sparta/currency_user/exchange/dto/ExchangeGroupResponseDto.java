package com.sparta.currency_user.exchange.dto;

import lombok.Getter;
import java.math.BigDecimal;

@Getter
public class ExchangeGroupResponseDto {

    private final Long count;
    private final BigDecimal totalAmountInKrw;

    public ExchangeGroupResponseDto(Long count, BigDecimal totalAmountInKrw) {

        this.count = count;
        this.totalAmountInKrw = totalAmountInKrw;
    }
}
