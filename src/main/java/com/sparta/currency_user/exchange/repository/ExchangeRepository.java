package com.sparta.currency_user.exchange.repository;

import com.sparta.currency_user.exchange.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    List<Exchange> findAllByUserId(Long userId);
}