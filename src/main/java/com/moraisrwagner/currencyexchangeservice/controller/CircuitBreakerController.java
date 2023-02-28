package com.moraisrwagner.currencyexchangeservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    public String sampleApi() {
        log.info("Sample Api Call Received");
        var response = new RestTemplate().getForEntity("http://localhost:8080/nothing", String.class);
        return response.getBody();
    }

    public String hardcodedResponse(Exception exception) {
        return "fallback-response";
    }
}
