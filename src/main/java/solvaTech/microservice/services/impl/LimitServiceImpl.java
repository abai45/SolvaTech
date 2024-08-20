package solvaTech.microservice.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import solvaTech.microservice.dtos.LimitDto;
import solvaTech.microservice.entities.LimitEntity;
import solvaTech.microservice.enums.CategoryEnum;
import solvaTech.microservice.mappers.LimitMapper;
import solvaTech.microservice.repositories.LimitRepository;
import solvaTech.microservice.services.LimitService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class LimitServiceImpl implements LimitService {
    private final LimitRepository limitRepository;
    private final LimitMapper limitMapper;

    @Override
    public LimitDto setLimit(String categoryName, String currency, BigDecimal newLimit) {
        var limitEntity = new LimitEntity();
        limitEntity.setCategoryEnum(CategoryEnum.valueOf(categoryName));
        limitEntity.setLimitSum(newLimit);
        limitEntity.setLimitDate(now());
        limitEntity.setLimitCurrency(currency);
        limitRepository.save(limitEntity);

        var limitDto = limitMapper.toDto(limitEntity);
        return limitDto;
    }

    @Override
    public List<LimitDto> getAllLimits() {
        List<LimitEntity> allEntity = limitRepository.findAll();
        List<LimitDto> allDto = allEntity.stream()
                .map(limitMapper::toDto)
                .collect(Collectors.toList());
        return allDto;
    }

    @Override
    public List<LimitDto> getLimitsByCategoryAndDate(String categoryName, LocalDateTime date) {
        var limits = limitRepository.findAll(); /* <-- Можно использовать фильтрацию через методы в репозитории,
                                                                 но я решил, что так веселее будет (: */
        return  limits.stream()
                .filter(limit ->
                        (categoryName == null || limit.getCategoryEnum().name().equalsIgnoreCase(categoryName)) &&
                        (date == null || limit.getLimitDate().toLocalDate().equals(date.toLocalDate()))
                ).map(limitMapper::toDto)
                .collect(Collectors.toList());
        /* Надеюсь вы не подумаете, что это извращение. Я просто решил попробовать какой то такой метод сделать */
    }
}
