package solvaTech.microservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDto {
    private String accountFrom;
    private String accountTo;
    private BigDecimal amount;
    private String currency;
    private String categoryName;
}
