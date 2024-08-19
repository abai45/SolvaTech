package solvaTech.microservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "t_rateExchange")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String currFrom;
    @Column(nullable = false, updatable = false)
    private String currTo;
    @Column(nullable = false, updatable = false, precision = 10, scale = 5)
    private BigDecimal rate;
    private LocalDate date;
}
