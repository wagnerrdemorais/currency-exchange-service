package com.moraisrwagner.currencyexchangeservice.controller;

import com.moraisrwagner.currencyexchangeservice.bean.CurrencyExchange;
import com.moraisrwagner.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class CurrencyExchangeController {

    private final Environment environment;
    private final CurrencyExchangeService currencyExchangeService;

    private final RestTemplate restTemplate;


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {
        var port = environment.getProperty("local.server.port");

        Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
        logger.info("request with info from: {}, to {}", from, to);

        CurrencyExchange byFromAndTo = currencyExchangeService.findByFromAndTo(from, to);
        byFromAndTo.setEnvironment(port);
        return byFromAndTo;
    }
}
