package solvaTech.microservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import solvaTech.microservice.dtos.LimitDto;
import solvaTech.microservice.entities.LimitEntity;
import solvaTech.microservice.enums.CategoryEnum;
import solvaTech.microservice.repositories.LimitRepository;
import solvaTech.microservice.services.LimitService;

import java.math.BigDecimal;
import java.util.List;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class LimitServiceImpl implements LimitService {
    private final LimitRepository limitRepository;

    @Override
    public LimitDto setLimit(String categoryName, String currency, BigDecimal newLimit) {
        var limitEntity = new LimitEntity();
        limitEntity.setCategoryEnum(CategoryEnum.valueOf(categoryName));
        limitEntity.setLimitSum(newLimit);
        limitEntity.setLimitDate(now());
        limitEntity.setLimitCurrency(currency);
        return null;
    }

    @Override
    public List<LimitDto> getAllLimits() {
        return null;
    }
}
