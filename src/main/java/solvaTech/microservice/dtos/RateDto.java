package solvaTech.microservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class RateDto {
    private String currFrom;
    private String currTo;
    private LocalDate date;
    private BigDecimal rate;
}
