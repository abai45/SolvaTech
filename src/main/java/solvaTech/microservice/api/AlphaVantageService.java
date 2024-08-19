package solvaTech.microservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaVantageService {

    private static final String BASE_URL = "https://www.alphavantage.co/query";
    private static final String API_KEY = "MD0Y50JT22516WBY";

    private final RestTemplate restTemplate;

    @Autowired
    public AlphaVantageService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String fetchDailyFXData(String fromSymbol, String toSymbol) {
        String function = "FX_DAILY";
        String url = String.format("%s?function=%s&from_symbol=%s&to_symbol=%s&apikey=%s",
                BASE_URL, function, fromSymbol, toSymbol, API_KEY);
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch daily FX data: " + e.getMessage());
        }
    }
}
