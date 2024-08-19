package solvaTech.microservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class LimitDto {
    private BigDecimal limitSum;
    private LocalDateTime limitDate;
    private String limitCurrency;
}
