package com.sparta.currency_user.common.validator;

import com.sparta.currency_user.currency.entity.Currency;
import com.sparta.currency_user.currency.repository.CurrencyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ValidatorCurrency {

    private final CurrencyRepository currencyRepository;

    @PostConstruct
    public void validatorCurrencyRate() {

        // Currency 데이터베이스로부터 통화 데이터 모두 조회
        List<Currency> currencies = currencyRepository.findAll();

        // 유효하지 않은 값
        for (Currency currency : currencies) {
            BigDecimal exchangeRate = currency.getExchangeRate();

            if (exchangeRate.setScale(0).equals(BigDecimal.ZERO)) {
                log.error(currency.getCurrencyName() + " 환율이 0입니다.");
            }

            if (exchangeRate.setScale(0).compareTo(BigDecimal.ZERO) < 0) {
                log.error(currency.getCurrencyName() + " 환율이 음수입니다.");
            }

            if (exchangeRate == null) {
                log.error(currency.getCurrencyName() + " 유효하지 않은 값입니다.");
            }
        }
    }
}
