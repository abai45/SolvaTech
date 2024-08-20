package solvaTech.microservice.services;

import solvaTech.microservice.dtos.LimitDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface LimitService {
    LimitDto setLimit(String categoryName, String currency, BigDecimal newLimit);
    List<LimitDto> getAllLimits();
    List<LimitDto> getLimitsByCategoryAndDate(String categoryName, LocalDateTime date);
}
