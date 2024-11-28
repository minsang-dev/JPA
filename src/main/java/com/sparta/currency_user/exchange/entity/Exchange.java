package com.sparta.currency_user.exchange.entity;

import com.sparta.currency_user.common.entity.TimeBaseEntity;
import com.sparta.currency_user.currency.entity.Currency;
import com.sparta.currency_user.exchange.enums.ExchangeStatus;
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

    // Enum class들을 column으로 가지고 있을 때 Enumerated 선언 (enum type을 string으로 선언해야 키 값이 문자로 바뀜)
    @Enumerated(EnumType.STRING)
    private ExchangeStatus status;

    public Exchange(User user, Currency currency, BigDecimal amountInKrw, BigDecimal amountAfterExchange, ExchangeStatus status) {
        this.user = user;
        this.currency = currency;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
    }

    public Exchange() {

    }
}
