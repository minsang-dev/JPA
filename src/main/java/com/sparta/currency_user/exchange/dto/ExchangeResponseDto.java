package com.sparta.currency_user.exchange.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class ExchangeResponseDto {
    private final Long id;
    private final Long userId;
    private final Long currencyId;
    private final BigDecimal amountInKrw;
    private final BigDecimal amountAfterExchange;
    private final String status;
    private final LocalDateTime createdAt;

    public ExchangeResponseDto(Long id, Long userId, Long currencyId, BigDecimal amountInKrw, BigDecimal amountAfterExchange, String status, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.currencyId = currencyId;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
        this.createdAt = createdAt;
    }
}
