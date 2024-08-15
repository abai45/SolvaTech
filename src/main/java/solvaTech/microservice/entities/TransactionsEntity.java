package solvaTech.microservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import solvaTech.microservice.enums.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountFrom;
    private String accountTo;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime dateTime;
    private boolean limitExceeded;
    private CategoryEnum categoryEnum;
}
