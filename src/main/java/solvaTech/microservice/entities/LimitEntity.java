package solvaTech.microservice.entities;

import jakarta.persistence.*;
import lombok.*;
import solvaTech.microservice.enums.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_limits")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LimitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false)
    private BigDecimal limitSum;
    @Column(nullable = false, updatable = false)
    private LocalDateTime limitDate;
    private String limitCurrency;
    @Enumerated(EnumType.STRING)
    private CategoryEnum categoryEnum;
}
