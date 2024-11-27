package com.sparta.currency_user.exchangeRequest.entity;

import com.sparta.currency_user.currency.entity.Currency;
import com.sparta.currency_user.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
    @Getter
    @Entity
    @Table(name = "EXCHANGEREQUEST")
    public class ExchangeRequest {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne
        @JoinColumn(name = "currency_id")
        private Currency currency;

        private Long amountInKrw;
        private BigDecimal amountAfterExchange;
        private String status;


}
