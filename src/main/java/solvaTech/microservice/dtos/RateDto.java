package solvaTech.microservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RateDto {
    private String currFrom;
    private String currTo;
    private LocalDate date;
    private BigDecimal rate;
}
