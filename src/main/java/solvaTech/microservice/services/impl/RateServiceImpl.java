package solvaTech.microservice.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import solvaTech.microservice.dtos.RateDto;
import solvaTech.microservice.entities.RateEntity;
import solvaTech.microservice.mappers.RateMapper;
import solvaTech.microservice.repositories.RateRepository;
import solvaTech.microservice.services.RateService;

import java.math.BigDecimal;

import static java.time.LocalDate.now;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {
    private final AlphaVantageService alphaVantage;
    private final RateRepository rateRepository;
    private final RateMapper rateMapper;
    @Override
    public RateDto getRate(String fromCurrency, String toCurrency) {
        try {
            String response = alphaVantage.fetchDailyFXData(fromCurrency, toCurrency);
            var objectMapper = new ObjectMapper();
            var rootNode = objectMapper.readTree(response);
            var timeSeries = rootNode.get("Time Series FX (Daily)");
            String latestDate = timeSeries.fieldNames().next();
            var latestData = timeSeries.get(latestDate);
            String closePrice = latestData.get("4. close").asText();
            BigDecimal rate = new BigDecimal(closePrice);

            RateDto rateDto = new RateDto(fromCurrency, toCurrency, now(), rate);
            RateEntity rateEntity = rateMapper.toEntity(rateDto);
            rateRepository.save(rateEntity);
            return rateDto;
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void fetchAndStoreDailyRates() {
        try {
            getRate("KZT", "USD");
            getRate("RUB", "USD");
        } catch (Exception e) {
            throw new RuntimeException("Failed to update rate: "+e);
        }
    }
}
