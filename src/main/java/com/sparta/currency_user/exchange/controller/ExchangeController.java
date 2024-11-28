package com.sparta.currency_user.exchange.controller;

import com.sparta.currency_user.exchange.dto.ExchangeRequestDto;
import com.sparta.currency_user.exchange.dto.ExchangeResponseDto;
import com.sparta.currency_user.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchanges")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    /**
     * 환전 요청 수행
     */
    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchangeRequest(
            @Validated @RequestBody ExchangeRequestDto requestDto) {

        ExchangeResponseDto responseDto = exchangeService.createExchangeRequest(
                requestDto.getUserId(),
                requestDto.getCurrencyId(),
                requestDto.getAmountInKrw()
        );
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * 특정 고객의 환전 요청 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<ExchangeResponseDto>> findExchangesRequest(
            @PathVariable Long id
    ) {
        List<ExchangeResponseDto> exchanges = exchangeService.findExchangesRequest(id);

        return new ResponseEntity<>(exchanges, HttpStatus.OK);
    }

    /**
     * 특정 환전 요청 상태 취소로 변경
     */
    @PatchMapping("/{exchangeId}")
    public ResponseEntity<ExchangeResponseDto> updateExchangeRequest(
            @PathVariable Long exchangeId
    ) {
        ExchangeResponseDto responseDto = exchangeService.updateExchangeRequest(exchangeId);

        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }

}
