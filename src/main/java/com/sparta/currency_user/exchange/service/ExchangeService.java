package com.sparta.currency_user.exchange.service;

import com.sparta.currency_user.currency.entity.Currency;
import com.sparta.currency_user.currency.repository.CurrencyRepository;
import com.sparta.currency_user.exchange.dto.ExchangeResponseDto;
import com.sparta.currency_user.exchange.entity.Exchange;
import com.sparta.currency_user.exchange.repository.ExchangeRepository;
import com.sparta.currency_user.user.entity.User;
import com.sparta.currency_user.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    @Transactional
    public ExchangeResponseDto createExchangeRequest(Long userId, Long currencyId, BigDecimal amountInKrw) {

        // 환전을 신청할 사용자 id
        User findUser = userRepository.findUserById(userId);
        // currency 테이블의 환율 가져오기 위함
        Currency findCurrency = currencyRepository.findCurrencyById(currencyId);

        /**
         * 환전 후 금액 = 환전 전 금액 / 환율
         */
        BigDecimal exchangeRate = findCurrency.getExchangeRate();
        BigDecimal amountAfterExchange = amountInKrw.divide(exchangeRate, 2, RoundingMode.HALF_UP);

        Exchange exchange = new Exchange(findUser, findCurrency, amountInKrw, amountAfterExchange, "NORMAL");
        Exchange savedExchange = exchangeRepository.save(exchange); // 저장

        return new ExchangeResponseDto(
                savedExchange.getId(),
                savedExchange.getUser().getId(),
                savedExchange.getCurrency().getId(),
                savedExchange.getAmountInKrw(),
                savedExchange.getAmountAfterExchange(),
                savedExchange.getStatus(),
                savedExchange.getCreatedAt()
        );
    }

    /**
     * List에 있는 고객들 중 특정 고객 조회
     * @param userId
     * @return
     */
    @Transactional
    public List<ExchangeResponseDto> findExchangesRequest(Long userId) {
        List<Exchange> exchangesList = exchangeRepository.findAllByUserId(userId);

        List<ExchangeResponseDto> exchangeResponseDtos = new ArrayList<>();

        for (Exchange exchange : exchangesList) {
            exchangeResponseDtos.add(new ExchangeResponseDto(
                    exchange.getId(),
                    exchange.getUser().getId(),
                    exchange.getCurrency().getId(),
                    exchange.getAmountInKrw(),
                    exchange.getAmountAfterExchange(),
                    exchange.getStatus(),
                    exchange.getCreatedAt()
            ));
        }

        return exchangeResponseDtos;
    }

    /**
     * 특정 환전 요청상태를 취소로 변경
     *
     * @return
     */
    @Transactional
    public ExchangeResponseDto updateExchangeRequest(Long exchangeId) {

        Exchange exchange = exchangeRepository.findById(exchangeId).orElseThrow(null);

        exchange.setStatus("CANCELLED");

        return new ExchangeResponseDto(
                exchange.getId(),
                exchange.getUser().getId(),
                exchange.getCurrency().getId(),
                exchange.getAmountInKrw(),
                exchange.getAmountAfterExchange(),
                exchange.getStatus(),
                exchange.getCreatedAt()
        );

    }
}
