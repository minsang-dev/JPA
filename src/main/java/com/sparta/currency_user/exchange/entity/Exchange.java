package com.sparta.currency_user.exchange.entity;

import com.sparta.currency_user.common.entity.TimeBaseEntity;
import com.sparta.currency_user.currency.entity.Currency;
import com.sparta.currency_user.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NamedEntityGraph
@Entity
@Table(name = "EXCHANGE")
public class Exchange extends TimeBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private BigDecimal amountInKrw;
    private BigDecimal amountAfterExchange;
    private String status;

    public Exchange(User user, Currency currency, BigDecimal amountInKrw, BigDecimal amountAfterExchange, String status) {
        this.user = user;
        this.currency = currency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
    }

    public Exchange() {

    }
}
