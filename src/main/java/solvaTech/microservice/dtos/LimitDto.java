package solvaTech.microservice.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import solvaTech.microservice.entities.AccountEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class LimitDto {
    private AccountEntity account;
    private BigDecimal limitSum;
    private LocalDateTime limitDate;
    private String limitCurrency;
}
