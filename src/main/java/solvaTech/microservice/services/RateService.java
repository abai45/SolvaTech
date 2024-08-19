package solvaTech.microservice.services;

import solvaTech.microservice.dtos.RateDto;

public interface RateService {
    RateDto getRate(String fromCurrency, String toCurrency);
    void fetchAndStoreDailyRates();
}
