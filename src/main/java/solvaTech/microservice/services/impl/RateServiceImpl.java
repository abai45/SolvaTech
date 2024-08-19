package solvaTech.microservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import solvaTech.microservice.dtos.RateDto;
import solvaTech.microservice.services.RateService;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {
    @Override
    public RateDto getRate(String fromCurrency, String toCurrency) {
        return null;
    }

    @Override
    public void fetchAndStoreDailyRates() {

    }
}
