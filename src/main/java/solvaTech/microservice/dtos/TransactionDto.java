package solvaTech.microservice.dtos;

import lombok.Getter;
import lombok.Setter;
import solvaTech.microservice.enums.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDto {
    private String accountFrom;
    private String accountTo;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime dateTime;
    private boolean limitExceeded;
    private CategoryEnum categoryEnum;
}
