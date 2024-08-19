package solvaTech.microservice.services;

import solvaTech.microservice.dtos.LimitDto;

import java.math.BigDecimal;
import java.util.List;

public interface LimitService {
    LimitDto setLimit(String categoryName, BigDecimal newLimit);
    List<LimitDto> getAllLimits();
}
