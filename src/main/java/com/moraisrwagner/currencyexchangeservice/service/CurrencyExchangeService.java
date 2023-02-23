package com.moraisrwagner.currencyexchangeservice.service;

import com.moraisrwagner.currencyexchangeservice.bean.CurrencyExchange;
import com.moraisrwagner.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@AllArgsConstructor
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchange findByFromAndTo(String from, String to) {
        return currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(from, to)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Currency Exchange not found!"));
    }
}
