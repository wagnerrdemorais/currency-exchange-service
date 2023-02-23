package com.moraisrwagner.currencyexchangeservice.repository;

import com.moraisrwagner.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    Optional<CurrencyExchange> findByCurrencyFromAndCurrencyTo(String from, String to);
}
