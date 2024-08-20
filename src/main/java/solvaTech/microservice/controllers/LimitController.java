package solvaTech.microservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solvaTech.microservice.dtos.LimitDto;
import solvaTech.microservice.dtos.LimitFilterDto;
import solvaTech.microservice.services.LimitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/api/limits")
public class LimitController {
    private final LimitService limitService;

    @PostMapping("/filter")
    public List<LimitDto> getFilteredLimits(@RequestBody LimitFilterDto limitFilterDto) {
        return limitService.getLimitsByCategoryAndDate(limitFilterDto.getCategoryName(), limitFilterDto.getDate());
    }
}
