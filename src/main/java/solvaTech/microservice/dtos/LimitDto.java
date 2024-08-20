package solvaTech.microservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LimitDto {
    private String categoryName;
    private String limitCurrency;
    private BigDecimal limitSum;
    private LocalDateTime limitDate;
}
