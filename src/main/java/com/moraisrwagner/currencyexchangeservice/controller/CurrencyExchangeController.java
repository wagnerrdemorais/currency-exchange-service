package com.moraisrwagner.currencyexchangeservice.controller;

import com.moraisrwagner.currencyexchangeservice.bean.CurrencyExchange;
import com.moraisrwagner.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {

        var port = environment.getProperty("local.server.port");
        CurrencyExchange byFromAndTo = currencyExchangeService.findByFromAndTo(from, to);
        byFromAndTo.setEnvironment(port);
        return byFromAndTo;
    }
}
