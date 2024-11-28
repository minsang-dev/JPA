package com.sparta.currency_user.exchange.repository;

import com.sparta.currency_user.exchange.dto.ExchangeGroupResponseDto;
import com.sparta.currency_user.exchange.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    List<Exchange> findAllByUserId(Long userId);

    @Query(
            // JPQL
            """
            SELECT new com.sparta.currency_user.exchange.dto.ExchangeGroupResponseDto(
                    COUNT(e.id),
                    SUM(e.amountInKrw)
            )
                    FROM Exchange e
                    WHERE e.user.id = :userId
                    Group by e.user.id
            """
    )

    ExchangeGroupResponseDto findExchangeGroupById(@Param("userId") Long userId);
}