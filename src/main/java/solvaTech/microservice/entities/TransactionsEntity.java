package solvaTech.microservice.entities;

import jakarta.persistence.*;
import lombok.*;
import solvaTech.microservice.enums.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_transactions")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String accountFrom;
    @Column(nullable = false, updatable = false)
    private String accountTo;
    @Column(nullable = false, updatable = false)
    private BigDecimal amount;
    @Column(nullable = false, updatable = false)
    private String currency;
    @Column(nullable = false, updatable = false)
    private LocalDateTime dateTime;
    @Column(nullable = false, updatable = false)
    private boolean limitExceeded;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, updatable = false)
    private CategoryEnum categoryEnum;
    @ManyToOne
    @JoinColumn(name = "limit_id")
    private LimitEntity limit;
}
