package solvaTech.microservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solvaTech.microservice.dtos.LimitDto;
import solvaTech.microservice.dtos.LimitFilterDto;
import solvaTech.microservice.services.LimitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/api/limits")
public class LimitController {
    private final LimitService limitService;

    @PostMapping("/set")
    public ResponseEntity<LimitDto> setNewLimit(@RequestBody LimitDto limitDto) {
        return ResponseEntity.ok(limitService.setLimit(limitDto.getCategoryName(), limitDto.getLimitCurrency(), limitDto.getLimitSum()));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<LimitDto>> getAllLimits() {
        return ResponseEntity.ok(limitService.getAllLimits());
    }

    @PostMapping("/filter")
    public ResponseEntity<List<LimitDto>> getFilteredLimits(@RequestBody LimitFilterDto limitFilterDto) {
        return ResponseEntity.ok(limitService.getLimitsByCategoryAndDate(limitFilterDto.getCategoryName(), limitFilterDto.getDate()));
    }
}
